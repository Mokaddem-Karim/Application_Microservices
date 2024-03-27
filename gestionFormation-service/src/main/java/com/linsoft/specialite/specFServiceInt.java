package com.linsoft.specialite;


import java.util.List;
import java.util.Optional;

public interface specFServiceInt {

    public specialiteF ajouterSpec(specialiteF sp);
    public Optional<specialiteF> getSpecById(int id);
    public List<specialiteF> getAllSpec();
    public String supprimerSpec(int id);



}
