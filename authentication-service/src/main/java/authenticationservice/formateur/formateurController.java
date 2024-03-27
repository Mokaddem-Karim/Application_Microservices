package authenticationservice.formateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formateur")
public class formateurController {

    @Autowired
    private final formateurServiceImpl fs;
    public formateurController(formateurServiceImpl fsi) {
        this.fs = fsi;
    }

    //test sur NULL to know existance of formateur
    @PostMapping("/save")
    public Formateur saveApp(@RequestBody Formateur f){
        Optional<Formateur> forr = null;
        forr=getForByMat(f.getMatricule());
        if(forr.isEmpty()) {
            return fs.ajouterFormateur(f);
        }else {
            return null;
        }

    }

    @GetMapping("/getFormateurById/{id}")
    public Optional<Formateur> getForById(@PathVariable int id){
        return fs.getForById(id);
    }

    @GetMapping("/getForByEmail/{mail}")
    public Formateur getForByEmail(@PathVariable String mail){
        return fs.findForByEmail(mail) ;
    }

    @GetMapping("/getAllFor")
    public List<Formateur> getAllFor(){
        return fs.getAllFormateur();
    }

    @DeleteMapping("/supprimerFormateur/{id}")
    public String supprimerFor(@PathVariable int id){
        return fs.supprimerFor(id);
    }

    @PutMapping("/modifierFormateur/{id}")
    public Formateur modifierFor(@RequestBody Formateur a, @PathVariable int id){
        return fs.modifierFor(a,id);
    }


    @GetMapping("/getForByMat/{matricule}")
    public Optional<Formateur> getForByMat(@PathVariable int matricule){
        return fs.getForByMatricule(matricule) ;
    }

    @GetMapping("/getAllForBySpec/{spec}")
    public List<Formateur> getForBySpec(@PathVariable String spec){
        return fs.getForBySpecialite(spec) ;
    }

}
