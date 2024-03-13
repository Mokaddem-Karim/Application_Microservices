package com.linsoft.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class formationServiceImpl implements formationServiceInt {


    @Autowired
    private formationRepo formationRepo;



    @Override
    public formation ajouterFormation(formation f) {
        return formationRepo.save(f);
    }

    @Override
    public Optional<formation> getFormationById(int id) {
        return formationRepo.findById(id);
    }

    @Override
    public List<formation> getAllFormation() {
        return formationRepo.findAll();
    }

    @Override
    public String supprimerFormation(int id) {
        formationRepo.deleteById(id);
        return "suppression avec succée";
    }

    @Override
    public formation modifierFormation(formation f, int id) {
        return formationRepo.findById(id).map(r -> {
            r.setLib(f.getLib());
            r.setDate(f.getDate());
            r.setImg(f.getImg());
            r.setChargeHoraire(f.getChargeHoraire());
            r.setLieu(f.getLieu());
            return formationRepo.save(r);
        }).orElseThrow(() -> new RuntimeException("formation inexistantante !"));
    }



}
