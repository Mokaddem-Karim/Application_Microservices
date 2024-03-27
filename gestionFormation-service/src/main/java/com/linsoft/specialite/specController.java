package com.linsoft.specialite;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/specialiteF")
public class specController {


    @Autowired
    private final specFServiceImpl sfs;


    public specController(specFServiceImpl sfss) {
        this.sfs = sfss;
    }


    @PostMapping("/save")
    public specialiteF saveSpecialite(@RequestBody specialiteF sf) {

        Optional<specialiteF> appf=null;
        appf=sfs.getSpecById(sf.getId());
        System.out.println(appf);
        if (!appf.isPresent()) {
            return ResponseEntity.ok(sfs.ajouterSpec(sf)).getBody();
        }else {  System.out.println("cet specialite existe");
            return null; }
    }

    @GetMapping("/getSpec/{id}")
    public Optional<specialiteF> getSpecById(@PathVariable int id) {
        return sfs.getSpecById(id);
    }


    @GetMapping("/getAllSpec")
    public List<specialiteF> getAllSpec() {
        return sfs.getAllSpec();
    }

    @DeleteMapping("/supprimerSpec/{id}")
    public String supprimerSpec(@PathVariable int id) {
        return sfs.supprimerSpec(id);
    }


}