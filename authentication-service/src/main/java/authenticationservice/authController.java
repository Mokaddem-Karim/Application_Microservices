package authenticationservice;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class authController {

    private final authService as;

    /*
    private final candidatServiceImpl cs;

    private final electeurServiceImpl es ;
*/
    //pour admin
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(as.register(request));
    }


    /*
    //register pour candidat and verify that a candidat already have an account or not
    @PostMapping("/registerCandidat")
    public ResponseEntity<AuthenticationResponse> registerCandidat(@RequestBody registerRequestCandidat request){
        Candidat c=null;
        c=cs.findCandidatByEmail(request.getEmail());
        if (c==null) {
            return ResponseEntity.ok(as.registerCandidat(request));
        }else {  System.out.println("mail existant");
                 return null; }


     //return as.registerCandidat(request); pour verifier le candidat filled
    }

    //register pour electeur
    @PostMapping("/registerElecteur")
    public ResponseEntity<AuthenticationResponse> registerElecteur(@RequestBody registerRequestElecteur request){
        Electeur e=null;
        e=es.findByEmail(request.getEmail());
        if (e==null) {
            return ResponseEntity.ok(as.registerElecteur(request));
        }else {  System.out.println("mail existant");
            return null; }

        // return ResponseEntity.ok(as.registerElecteur(request));
        //return as.registerElecteur(request); pour verifier le electeur filled
    }

     */

    //pour tout le monde
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> auhthenticate(@RequestBody AuthenticationRequest request){
        System.out.println(request.getEmail()+" "+request.getPassword());

        return ResponseEntity.ok(as.authenticate(request));
    }


    //changer mdp

    @PostMapping("/changerMDP")
    public String changerMDP(@RequestBody ChangerRequest changerRequest){

        System.out.println("mail: " +changerRequest.getEmail());
       return as.changerMDP(changerRequest);
      // return as.changerMDP(email,mdp,newMDP);
    }





}
