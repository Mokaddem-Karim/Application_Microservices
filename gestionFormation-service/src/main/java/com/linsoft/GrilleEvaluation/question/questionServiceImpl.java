package com.linsoft.GrilleEvaluation.question;

import com.linsoft.GrilleEvaluation.grille.grilleEva;
import com.linsoft.GrilleEvaluation.grille.grilleEvaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class questionServiceImpl implements questionServiceInt {

    @Autowired
    private questionRepo qr;

    @Override
    public question ajouterQuestion(question q) {
        return qr.save(q);
    }

    @Override
    public Optional<question> getQuestionById(int id) {
        return qr.findById(id);
    }

    @Override
    public List<question> getAllQuestion() {
        return qr.findAll();
    }

    @Override
    public String supprimerQuestion(int id) {
        qr.deleteById(id);
        return "suppression avec sucée";
    }
}
