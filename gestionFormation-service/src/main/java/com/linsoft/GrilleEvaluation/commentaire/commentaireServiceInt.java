package com.linsoft.GrilleEvaluation.commentaire;

import com.linsoft.formation.formation;

import java.util.List;
import java.util.Optional;

public interface commentaireServiceInt {

    public commentaire ajouterCommentaire(commentaire c);
    public Optional<commentaire> getCommentaireById(int id);
    public List<commentaire> getAllCommentaire();
    public String supprimerCommentaire(int id);
    public commentaire modifierCommentaire(commentaire c, int id);
}
