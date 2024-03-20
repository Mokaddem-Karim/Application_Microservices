package com.linsoft.formation;


import java.util.List;
import java.util.Optional;

public interface formationServiceInt {

    public formation ajouterFormation(formation f);
    public Optional<formation> getFormationById(int id);
    public List<formation> getAllFormation();
    public String supprimerFormation(int id);
    public formation modifierFormation(formation f, int id);
    public String verifDisponibilite();


}
