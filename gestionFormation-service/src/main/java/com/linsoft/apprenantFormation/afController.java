package com.linsoft.apprenantFormation;


import com.linsoft.formation.formateurDTO;
import com.linsoft.formation.formation;
import com.linsoft.formation.formationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apprenantFormation")
public class afController {


    @Autowired
    private final afServiceImpl afs;


    public afController(afServiceImpl afss) {
        this.afs = afss;
    }


    @PostMapping("/save")
    public apprenantFormation saveFormation(@RequestBody apprenantFormation af) {

        Optional<apprenantFormation> appf=null;
        appf=afs.findOneByIdFormationAndIdApprenant(af.getIdFormation(),af.getIdApprenant());
        System.out.println(appf);
        // System.out.println("cet relation existe: "+ appf);
        if (!appf.isPresent()) {
            return ResponseEntity.ok(afs.ajouterAF(af)).getBody();
        }else {  System.out.println("cet relation existant");
            return null; }
    }

    @GetMapping("/getAF/{id}")
    public Optional<apprenantFormation> getAFById(@PathVariable int id) {
        return afs.getAFById(id);
    }


    @GetMapping("/getAllAF")
    public List<apprenantFormation> getAllAF() {
        return afs.getAllAF();
    }

    @DeleteMapping("/supprimerAF/{id}")
    public String supprimerAF(@PathVariable int id) {
        return afs.supprimerAF(id);
    }

    @GetMapping("/getAppFRelationByIdAppAndIdF/{idApp}/{idF}")
    public Optional<apprenantFormation> getAFByIdAAndIdF(@PathVariable int idApp,@PathVariable int idF) {

        return afs.findOneByIdFormationAndIdApprenant(idF,idApp);
    }

}