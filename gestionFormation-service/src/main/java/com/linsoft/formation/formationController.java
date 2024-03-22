package com.linsoft.formation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formation")
public class formationController {




    @Autowired
    private final formationServiceImpl fs;

    @Autowired
    private RestTemplate restTemplate;
    public formationController(formationServiceImpl fss) {
        this.fs = fss;
    }


    //function that consume an api from microservice auth, to getFormateurByMatricule
    @GetMapping("/verifFormateur/{matricule}")
    public boolean checkFormateurExist(@PathVariable int matricule) {
        String url = "http://localhost:8023/formateur/getForByMat/" + matricule;
        try {
            ResponseEntity<formateurDTO> response = restTemplate.getForEntity(url, formateurDTO.class);
            if (response.getBody()!=null) {
                System.out.println(response.getBody());
                return true;
            } else {
                System.out.println(response.getBody());
                return false;
            }
        } catch (HttpClientErrorException.NotFound ex) {
            return false;
        }
    }

    @PostMapping("/save")
    public formation saveFormation(@RequestBody formation f){
         //System.out.println(f);
        if(checkFormateurExist(f.getFormateurMatricule())) {
            return fs.ajouterFormation(f);
        }else{
            return null ;
        }
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
