package com.linsoft.fichePresence;

import com.linsoft.GrilleEvaluation.commentaire.commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class fichePresenceServiceImpl implements fichePresenceServiceInt {

    @Autowired
    private fichePresenceRepo fpr;

    @Override
    public fichePresence ajouterFicheP(fichePresence fp) {
        return fpr.save(fp);
    }

    @Override
    public Optional<fichePresence> getFPById(int id) {
        return fpr.findById(id);
    }

    @Override
    public List<fichePresence> getAllFP() {
        return fpr.findAll();
    }

    @Override
    public String supprimerFP(int id) {
        fpr.deleteById(id);
        return "suppression avec sucéee";
    }
}
