package com.linsoft.formation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formation")
public class formationController {



    @Autowired
    private final formationServiceImpl fs;
    public formationController(formationServiceImpl fss) {
        this.fs = fss;
    }

    @PostMapping("/save")
    public formation saveFormation(@RequestBody formation f){
        return fs.ajouterFormation(f);
    }

    @GetMapping("/getFormation/{id}")
    public Optional<formation> getFormationById(@PathVariable int id){
        return fs.getFormationById(id);
    }


    @GetMapping("/getAllFormation")
    public List<formation> getAllFormation(){
        return fs.getAllFormation();
    }

    @DeleteMapping("/supprimerFormation/{id}")
    public String supprimerFormation(@PathVariable int id){
        return fs.supprimerFormation(id);
    }

    @PutMapping("/modifierFormation/{id}")
    public formation modifierFormation(@RequestBody formation f, @PathVariable int id){
        return fs.modifierFormation(f,id);
    }

    @GetMapping("/checkDisponibilite")
    public String checkDisponibilite(){
        return fs.verifDisponibilite();
    }

}
