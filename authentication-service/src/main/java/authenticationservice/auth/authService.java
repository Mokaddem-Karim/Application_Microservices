package authenticationservice.auth;

import authenticationservice.reset.ChangerRequest;
import authenticationservice.user.Role;
import authenticationservice.apprenant.Apprenant;
import authenticationservice.apprenant.apprenantRepo;
import authenticationservice.apprenant.registerRequestApprenant;
import authenticationservice.reset.emailUtil;
import authenticationservice.formateur.Formateur;
import authenticationservice.formateur.formateurRepo;
import authenticationservice.formateur.registerRequestFormateur;
import authenticationservice.reset.resetReq;
import authenticationservice.user.User;
import authenticationservice.user.userRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import authenticationservice.respInventaire.*;
import authenticationservice.respFormation.*;

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


    //repo of formateur
    private final formateurRepo formRepository;

    //repo of respFormation
    private final respFormationRepo respFormationRepo;

    //repo of respInv
    private final respInventaireRepo respInventaireRepo;





    //emailUtil functions
    private final emailUtil eu;


    //register of an admin from backend only
    public AuthenticationResponse register(RegisterRequest request) {

            var user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .pass(passwordEncoder.encode(request.getPassword()))
                    .role(Role.ADMIN)
                    .build();
            repository.save(user);
            //generation of token..
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder().token(jwtToken).build();

    }



    //inscription apprenant
    public AuthenticationResponse registerApprenant(registerRequestApprenant request) {

        Apprenant a =new Apprenant();
        a.setCin(request.getCin());
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



    //inscription formateur
    public AuthenticationResponse registerFormateur(registerRequestFormateur request) {

        Formateur a =new Formateur();
        a.setMatricule(request.getMatricule());
        a.setNom(request.getNom());
        a.setPrenom(request.getPrenom());
        a.setEmail(request.getEmail());
        a.setPassword(passwordEncoder.encode(request.getPassword()));
        a.setDateN(request.getDateN());
        a.setTel(request.getTel());
        a.setAdresse(request.getAdresse());
        formRepository.save(a);  //save sans autorisation admin

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

    //inscription respFormation et role.respF dés le départ
    public AuthenticationResponse registerRespFor(registerRequestRespFormation request) {

        respFormation a =new respFormation();
        a.setMatricule(request.getMatricule());
        a.setNom(request.getNom());
        a.setPrenom(request.getPrenom());
        a.setEmail(request.getEmail());
        a.setPassword(passwordEncoder.encode(request.getPassword()));
        a.setDateN(request.getDateN());
        a.setTel(request.getTel());
        a.setAdresse(request.getAdresse());
        respFormationRepo.save(a);  //save sans autorisation admin

        var user=User.builder()
                .firstName(request.getPrenom())
                .lastName(request.getNom())
                .email(request.getEmail())
                .pass(passwordEncoder.encode(request.getPassword()))
                .role(Role.ResponsableF)
                .build();
        repository.save(user);
        //generation of token..
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
        //   return c;
    }
    //inscription respInv
    public AuthenticationResponse registerRespInv(registerRequestRespInventaire request) {

        respInventaire a =new respInventaire();
        a.setMatricule(request.getMatricule());
        a.setNom(request.getNom());
        a.setPrenom(request.getPrenom());
        a.setEmail(request.getEmail());
        a.setPassword(passwordEncoder.encode(request.getPassword()));
        a.setDateN(request.getDateN());
        a.setTel(request.getTel());
        a.setAdresse(request.getAdresse());
        respInventaireRepo.save(a);  //save sans autorisation admin

        var user=User.builder()
                .firstName(request.getPrenom())
                .lastName(request.getNom())
                .email(request.getEmail())
                .pass(passwordEncoder.encode(request.getPassword()))
                .role(Role.ResponsableInv)
                .build();
        repository.save(user);
        //generation of token..
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
        //   return c;
    }

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

    public String forgotPassword(String email) throws MessagingException {
        User u1=repository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("user not found with this email: "+email)
        );
        try {
            eu.sendSetPasswordEmail(email);
        }catch (MessagingException e){
            throw new RuntimeException("unable to set email !");
        }
        return "Mail envoyer, verifier inbox !";
    }

    public String setPass(resetReq r) throws MessagingException {
        String email=r.getEmail();
        String pass=r.getNewPass();
        User u1=repository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("user not found with this email: "+email)
        );

           u1.setPass(passwordEncoder.encode(pass) );
           repository.save(u1);
        return "Succes, mot de passe changer !";
    }

}
