package com.linsoft.GrilleEvaluation.section;

import com.linsoft.GrilleEvaluation.question.question;

import java.util.List;
import java.util.Optional;

public interface sectionServiceInt {

    public section ajouterSection(section s);
    public Optional<section> getSectionById(int id);
    public List<section> getAllSection();
    public String supprimerSection(int id);
    //public grille modifierSection(section s, int id);
}
