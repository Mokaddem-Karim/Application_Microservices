package authenticationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apprenant")

public class apprenantController {



    @Autowired
    private final apprenantServiceImpl as;
    public apprenantController(apprenantServiceImpl as) {
        this.as = as;
    }

    @PostMapping("/save")
    public Apprenant saveApp(@RequestBody Apprenant a){
        return as.ajouterApprenant(a);
    }

    @GetMapping("/getApprenantById/{id}")
    public Optional<Apprenant> getCanById(@PathVariable int id){
        return as.getAppById(id);
    }

    @GetMapping("/getAppByEmail/{mail}")
    public Apprenant getCanByEmail(@PathVariable String mail){
        return as.findAppByEmail(mail) ;
    }

    @GetMapping("/getAllApp")
    public List<Apprenant> getAllCan(){
        return as.getAllApprenant();
    }

    @DeleteMapping("/supprimerApprenant/{id}")
    public String supprimerApp(@PathVariable int id){
        return as.supprimerApp(id);
    }

    @PutMapping("/modifierApprenant/{id}")
    public Apprenant modifierCan(@RequestBody Apprenant a, @PathVariable int id){
        return as.modifierApp(a,id);
    }





}
