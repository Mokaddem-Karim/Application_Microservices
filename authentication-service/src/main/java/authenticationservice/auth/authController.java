package authenticationservice.auth;


import authenticationservice.reset.ChangerRequest;
import authenticationservice.apprenant.Apprenant;
import authenticationservice.apprenant.apprenantServiceImpl;
import authenticationservice.apprenant.registerRequestApprenant;
import authenticationservice.formateur.Formateur;
import authenticationservice.formateur.formateurServiceImpl;
import authenticationservice.formateur.registerRequestFormateur;
import authenticationservice.reset.resetReq;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import authenticationservice.respInventaire.*;
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class authController {

    private final authService as;


    private final apprenantServiceImpl apps;

    private final formateurServiceImpl fs ;

    private final respInventaireServiceImpl rs ;

    //pour admin
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(as.register(request));
    }



    //register pour apprenant and verify that a apprenant already have an account or not
    @PostMapping("/registerApprenant")
    public ResponseEntity<AuthenticationResponse> registerApprenant(@RequestBody registerRequestApprenant request){
        Apprenant a=null;
        a=apps.findAppByEmail(request.getEmail());
        if (a==null) {
            return ResponseEntity.ok(as.registerApprenant(request));
        }else {  System.out.println("mail existant");
                 return null; }


     //return as.registerCandidat(request); pour verifier le candidat filled
    }


    //register pour formateur
    @PostMapping("/registerFormateur")
    public ResponseEntity<AuthenticationResponse> registerFormateur(@RequestBody registerRequestFormateur request){
        Formateur f=null;
        f=fs.findForByEmail(request.getEmail());
        if (f==null) {
            return ResponseEntity.ok(as.registerFormateur(request));
        }else {  System.out.println("mail existant");
            return null; }

        // return ResponseEntity.ok(as.registerFormateur(request));
        //return as.registerElecteur(request); pour verifier userfilled
    }

    //register pour formateur
    @PostMapping("/registerRespInv")
    public ResponseEntity<AuthenticationResponse> registerRespInv(@RequestBody registerRequestRespInventaire request){
        respInventaire r=null;
        r=rs.findRespInvByEmail(request.getEmail());
        if (r==null) {
            return ResponseEntity.ok(as.registerRespInv(request));
        }else {  System.out.println("mail existant");
            return null; }

        // return ResponseEntity.ok(as.registerFormateur(request));
        //return as.registerElecteur(request); pour verifier userfilled
    }



    //pour tout le monde
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> auhthenticate(@RequestBody AuthenticationRequest request){
        System.out.println(request.getEmail()+" "+request.getPassword());

        return ResponseEntity.ok(as.authenticate(request));
    }


    //changer mdp manually
    @PostMapping("/changerMDP")
    public String changerMDP(@RequestBody ChangerRequest changerRequest){

        System.out.println("mail: " +changerRequest.getEmail());
       return as.changerMDP(changerRequest);
      // return as.changerMDP(email,mdp,newMDP);
    }

    //reset password  via mail

    @PutMapping("/forgot-password")
    public String forgotPass(@RequestParam String email) throws MessagingException {
        return as.forgotPassword(email);
    }


    @PostMapping("/set-password")
    public String setPass(@RequestBody resetReq r) throws MessagingException {
        return as.setPass(r);
    }



}
