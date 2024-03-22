package com.linsoft.GrilleEvaluation.question;

import com.linsoft.GrilleEvaluation.grille.grilleEva;

import java.util.List;
import java.util.Optional;

public interface questionServiceInt {

    public question ajouterQuestion(question q);
    public Optional<question> getQuestionById(int id);
    public List<question> getAllQuestion();
    public String supprimerQuestion(int id);
    //public question modifierQuestion(question q, int id);
}
