package authenticationservice.respInventaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsableInventaire")

public class respInventaireController {



    @Autowired
    private final respInventaireServiceImpl rs;
    public respInventaireController(respInventaireServiceImpl rss) {
        this.rs = rss;
    }

    @PostMapping("/save")
    public respInventaire saveApp(@RequestBody respInventaire a){
        return rs.ajouterRespInv(a);
    }

    @GetMapping("/getRespInvById/{id}")
    public Optional<respInventaire> getRespInvById(@PathVariable int id){
        return rs.getRespInvById(id);
    }

    @GetMapping("/getRespInvByEmail/{mail}")
    public respInventaire getRespInvByEmail(@PathVariable String mail){
        return rs.findRespInvByEmail(mail) ;
    }

    @GetMapping("/getAllRespInv")
    public List<respInventaire> getAllApp(){
        return rs.getAllRespInv();
    }

    @DeleteMapping("/supprimerRespInv/{id}")
    public String supprimerRespInv(@PathVariable int id){
        return rs.supprimerRespInv(id);
    }

    @PutMapping("/modifierRespInv/{id}")
    public respInventaire modifierRespInv(@RequestBody respInventaire a, @PathVariable int id){
        return rs.modifierRespInv(a,id);
    }





}
