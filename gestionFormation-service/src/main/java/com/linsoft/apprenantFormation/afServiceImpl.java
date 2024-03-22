package com.linsoft.apprenantFormation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class afServiceImpl implements apServiceInt {

    @Autowired
    private afRepo afr;


    @Override
    public apprenantFormation ajouterAF(apprenantFormation af) {
        return afr.save(af);
    }

    @Override
    public Optional<apprenantFormation> getAFById(int id) {
        return afr.findById(id);
    }

    @Override
    public List<apprenantFormation> getAllAF() {
        return afr.findAll();
    }

    @Override
    public String supprimerAF(int id) {
        afr.deleteById(id);
        return "suppression avec succée";
    }

    @Override
    public Optional<apprenantFormation> findOneByIdFormationAndIdApprenant(int idF, int idA) {
        return  afr.findOneByIdFormationAndIdApprenant(idF,idA);
    }

}