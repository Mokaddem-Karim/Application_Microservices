package com.linsoft.apprenantFormation;


import com.linsoft.formation.formation;

import java.util.List;
import java.util.Optional;

public interface apServiceInt {

    public apprenantFormation ajouterAF(apprenantFormation af);
    public Optional<apprenantFormation> getAFById(int id);
    public List<apprenantFormation> getAllAF();
    public String supprimerAF(int id);

    Optional<apprenantFormation> findOneByIdFormationAndIdApprenant(int idF,int idA);


    //  public specialiteF modifierAF(specialiteF af, int id);



}
