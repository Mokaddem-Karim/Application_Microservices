package com.linsoft.fichePresence;

import com.linsoft.GrilleEvaluation.commentaire.commentaire;

import java.util.List;
import java.util.Optional;

public interface fichePresenceServiceInt {

    public fichePresence ajouterFicheP(fichePresence fp);
    public Optional<fichePresence> getFPById(int id);
    public List<fichePresence> getAllFP();
    public String supprimerFP(int id);
   // public fichePresence modifierFP(fichePresence fp, int id);
}
