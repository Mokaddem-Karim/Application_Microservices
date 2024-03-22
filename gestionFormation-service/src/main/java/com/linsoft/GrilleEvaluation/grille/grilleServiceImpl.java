package com.linsoft.GrilleEvaluation.grille;

import com.linsoft.GrilleEvaluation.commentaire.commentaire;
import com.linsoft.GrilleEvaluation.commentaire.commentaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class grilleServiceImpl implements grilleServiceInt {

    @Autowired
    private grilleEvaRepo gr;

    @Override
    public grilleEva ajouterGrille(grilleEva g) {
        return gr.save(g);
    }

    @Override
    public Optional<grilleEva> getGrilleById(int id) {
        return gr.findById(id);
    }

    @Override
    public List<grilleEva> getAllGrille() {
        return gr.findAll();
    }

    @Override
    public String supprimerGrille(int id) {
        gr.deleteById(id);
        return "suppression avec sucée";
    }
}
