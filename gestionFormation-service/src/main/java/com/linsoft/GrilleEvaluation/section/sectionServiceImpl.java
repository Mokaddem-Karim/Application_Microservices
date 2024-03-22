package com.linsoft.GrilleEvaluation.section;

import com.linsoft.GrilleEvaluation.question.question;
import com.linsoft.GrilleEvaluation.question.questionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class sectionServiceImpl implements sectionServiceInt {

    @Autowired
    private sectionRepo sr;

    @Override
    public section ajouterSection(section s) {
        return sr.save(s);
    }

    @Override
    public Optional<section> getSectionById(int id) {
        return sr.findById(id);
    }

    @Override
    public List<section> getAllSection() {
        return sr.findAll();
    }

    @Override
    public String supprimerSection(int id) {
        sr.deleteById(id);
        return "suppression avec succée";
    }
}
