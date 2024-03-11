package authenticationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class authService {



    //repo of user
    private final userRepository repository;

    //inject pass encoder service;
    private final PasswordEncoder passwordEncoder;
    //inject jwtService
    private final JwtService jwtService;

    //inject manager
    private final AuthenticationManager authenticationManager;



    //repo of apprenant
    private final apprenantRepo appRepository;

    /*
    //repo of electeur
    private final electeurRepo elecRepository;

   */

    public AuthenticationResponse register(RegisterRequest request) {

        var user=User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .pass(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        //generation of token..
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }



    //inscription candidat
    public AuthenticationResponse registerApprenant(registerRequestApprenant request) {

        Apprenant a =new Apprenant();
        a.setMatricule(request.getMatricule());
        a.setNom(request.getNom());
        a.setPrenom(request.getPrenom());
        a.setEmail(request.getEmail());
        a.setPassword(passwordEncoder.encode(request.getPassword()));
        a.setDateN(request.getDateN());
        a.setTel(request.getTel());
        a.setAdresse(request.getAdresse());
        appRepository.save(a);  //save sans autorisation admin

        var user=User.builder()
                .firstName(request.getPrenom())
                .lastName(request.getNom())
                .email(request.getEmail())
                .pass(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        //generation of token..
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
      //   return c;
    }


    /*
    //inscription electeur
    public AuthenticationResponse registerElecteur(registerRequestElecteur request) {

        Electeur e =new Electeur();
        e.setCin(request.getCin());
        e.setNom(request.getNom());
        e.setPrenom(request.getPrenom());
        e.setEmail(request.getEmail());
        e.setPassword(passwordEncoder.encode(request.getPassword()));
        e.setDateN(request.getDateN());
        e.setRegion(request.getRegion());
        e.setGenre(request.getGenre());
        elecRepository.save(e);  //save de l'electeur table elec

        var user=User.builder()
                .firstName(request.getNom())
                .lastName(request.getPrenom())
                .email(request.getEmail())
                .pass(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        //generation of token..
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
        //   return c;
    }


     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user=repository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }


    //changer mdp
    public String changerMDP(ChangerRequest changerRequest){
        Optional<User> user=repository.findByEmail(changerRequest.getEmail());

        if(user.isPresent()){
            User u1=user.get();
            if(passwordMatches(changerRequest.getEmail(),changerRequest.getMdp())) {
                u1.setPass(passwordEncoder.encode(changerRequest.getNewMDP()));
                repository.save(u1);
                return "user found" + "pass changer from "+changerRequest.getMdp()+" to "+changerRequest.getNewMDP();
            }
            else {
                return "pass not compatible";
            }

        }else {
            return "uset not found !!";
        }


    }


    private boolean passwordMatches(String email, String password) {
        Optional<User> user = repository.findByEmail(email);
        return passwordEncoder.matches(password, user.get().getPassword());
    }

}
