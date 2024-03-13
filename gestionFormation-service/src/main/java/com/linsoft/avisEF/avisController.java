package com.linsoft.avisEF;

import com.linsoft.formation.formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avis")

public class avisController {



    @Autowired
    private final avisServiceImpl avisService;
    public avisController(avisServiceImpl fss) {
        this.avisService = fss;
    }

    @PostMapping("/save")
    public avis saveAvis(@RequestBody avis a){
        return avisService.ajouterAvis(a);
    }

    @GetMapping("/getAvisById/{id}")
    public Optional<avis> getAvisById(@PathVariable int id){
        return avisService.getAvisById(id);
    }

    @GetMapping("/getAllAvis")
    public List<avis> getAllAvis(){
        return avisService.getAllAvis();
    }

    @DeleteMapping("/supprimerAvis/{id}")
    public String supprimerAvis(@PathVariable int id){
        return avisService.supprimerAvis(id);
    }

    @PutMapping("/modifierAvis/{id}")
    public avis modifierAvis(@RequestBody avis a, @PathVariable int id){
        return avisService.modifierAvis(a,id);
    }





}
