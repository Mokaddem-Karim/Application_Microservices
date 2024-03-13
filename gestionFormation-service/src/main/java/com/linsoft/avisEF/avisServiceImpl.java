package com.linsoft.avisEF;

import com.linsoft.formation.formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class avisServiceImpl implements avisServiceInt {


    @Autowired
    private avisRepo avisRepo;



    @Override
    public avis ajouterAvis(avis av) {
        return avisRepo.save(av);
    }

    @Override
    public Optional<avis> getAvisById(int id) {
        return avisRepo.findById(id);
    }

    @Override
    public List<avis> getAllAvis() {
        return avisRepo.findAll();
    }

    @Override
    public String supprimerAvis(int id) {
        avisRepo.deleteById(id);
        return "suppression avec succée";
    }

    @Override
    public avis modifierAvis(avis a, int id) {
        return avisRepo.findById(id).map(r -> {
            r.setId(a.getId());
            r.setDetails(a.getDetails());
            r.setNote(a.getNote());
            r.setIdFormation(a.getIdFormation());
            r.setIdApprenant(a.getIdApprenant());
            return avisRepo.save(r);
        }).orElseThrow(() -> new RuntimeException("avis inexistantante !"));
    }



}
