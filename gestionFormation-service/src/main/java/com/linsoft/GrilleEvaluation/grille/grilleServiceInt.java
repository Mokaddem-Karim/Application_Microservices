package com.linsoft.GrilleEvaluation.grille;

import com.linsoft.GrilleEvaluation.commentaire.commentaire;

import java.util.List;
import java.util.Optional;

public interface grilleServiceInt {

    public grilleEva ajouterGrille(grilleEva g);
    public Optional<grilleEva> getGrilleById(int id);
    public List<grilleEva> getAllGrille();
    public String supprimerGrille(int id);
    //public grille modifierGrille(grille g, int id);
}
