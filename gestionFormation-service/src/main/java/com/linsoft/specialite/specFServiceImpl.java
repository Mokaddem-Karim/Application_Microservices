package com.linsoft.specialite;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class specFServiceImpl implements specFServiceInt {

    @Autowired
    private specialiteFRepo sfr;

    @Override
    public specialiteF ajouterSpec(specialiteF sp) {
        return sfr.save(sp);
    }

    @Override
    public Optional<specialiteF> getSpecById(int id) {
        return sfr.findById(id);
    }

    @Override
    public List<specialiteF> getAllSpec() {
        return sfr.findAll();
    }

    @Override
    public String supprimerSpec(int id) {
        sfr.deleteById(id);
        return "suppression avec sucée";
    }
}