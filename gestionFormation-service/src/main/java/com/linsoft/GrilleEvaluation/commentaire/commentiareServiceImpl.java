package com.linsoft.GrilleEvaluation.commentaire;

import com.linsoft.formation.formation;
import com.linsoft.formation.formationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class commentiareServiceImpl implements commentaireServiceInt{

    @Autowired
    private commentaireRepo cr;

    @Override
    public commentaire ajouterCommentaire(commentaire c) {
        return cr.save(c) ;
    }

    @Override
    public Optional<commentaire> getCommentaireById(int id) {
        return cr.findById(id);
    }

    @Override
    public List<commentaire> getAllCommentaire() {
        return cr.findAll();
    }

    @Override
    public String supprimerCommentaire(int id) {
        cr.deleteById(id);
        return "suppression avec succée";
    }

    //not implemented
    @Override
    public commentaire modifierCommentaire(commentaire c, int id) {
        return null;
    }
}
