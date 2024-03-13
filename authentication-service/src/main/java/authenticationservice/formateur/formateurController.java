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

    @PostMapping("/save")
    public Formateur saveApp(@RequestBody Formateur f){
        return fs.ajouterFormateur(f);
    }

    @GetMapping("/getFormateurById/{id}")
    public Optional<Formateur> getForById(@PathVariable int id){
        return fs.getForById(id);
    }

    @GetMapping("/getForByEmail/{mail}")
    public Formateur getForByEmail(@PathVariable String mail){
        return fs.findForByEmail(mail) ;
    }

    @GetMapping("/getAllApp")
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



}
