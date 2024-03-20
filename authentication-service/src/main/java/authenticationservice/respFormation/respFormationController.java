package authenticationservice.respFormation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsableFormation")

public class respFormationController {



    @Autowired
    private final respFormationServiceImpl rs;
    public respFormationController(respFormationServiceImpl rss) {
        this.rs = rss;
    }

    @PostMapping("/save")
    public respFormation saveRespFor(@RequestBody respFormation a){
        return rs.ajouterRespFor(a);
    }

    @GetMapping("/getRespForById/{id}")
    public Optional<respFormation> getRespForById(@PathVariable int id){
        return rs.getRespForById(id);
    }

    @GetMapping("/getRespForByEmail/{mail}")
    public respFormation getRespForByEmail(@PathVariable String mail){
        return rs.findRespForByEmail(mail) ;
    }

    @GetMapping("/getAllRespFor")
    public List<respFormation> getAllRespFor(){
        return rs.getAllRespFor();
    }

    @DeleteMapping("/supprimerRespFor/{id}")
    public String supprimerRespFor(@PathVariable int id){
        return rs.supprimerRespFor(id);
    }

    @PutMapping("/modifierRespInv/{id}")
    public respFormation modifierRespInv(@RequestBody respFormation a, @PathVariable int id){
        return rs.modifierRespFor(a,id);
    }





}
