package authenticationservice.formateur;

import java.util.List;
import java.util.Optional;

public interface formateurServiceInt {

    public Formateur ajouterFormateur(Formateur f);
    public Optional<Formateur> getForById(int a);
    public List<Formateur> getAllFormateur();
    public String supprimerFor(int id);
    public Formateur modifierFor(Formateur f, int id);


    public Formateur findForByEmail(String email) ;
}
