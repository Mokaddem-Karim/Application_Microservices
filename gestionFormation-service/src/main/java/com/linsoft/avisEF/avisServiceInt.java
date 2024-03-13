package com.linsoft.avisEF;



import com.linsoft.formation.formation;

import java.util.List;
import java.util.Optional;

public interface avisServiceInt {

    public avis ajouterAvis(avis f);
    public Optional<avis> getAvisById(int id);
    public List<avis> getAllAvis();
    public String supprimerAvis(int id);
    public avis modifierAvis(avis av, int id);



}
