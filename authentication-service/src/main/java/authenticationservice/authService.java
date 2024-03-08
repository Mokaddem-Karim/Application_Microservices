package com.linfsoft.authenticationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

   /*
    //repo of candidat
    private final candidatRepo canRepository;

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


    /*
    //inscription candidat
    public AuthenticationResponse registerCandidat(registerRequestCandidat request) {

        Candidat c =new Candidat();
        c.setCin(request.getCin());
        c.setNom(request.getNom());
        c.setPrenom(request.getPrenom());
        c.setEmail(request.getEmail());
        c.setGroupe(request.getGroupe());
        c.setPassword(passwordEncoder.encode(request.getPassword()));
        c.setDateN(request.getDateN());
        c.setAnnonceV(request.getAnnonceV());
        c.setImgUrl(request.getImgUrl());
        canRepository.save(c);  //save sans autorisation admin

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






}
