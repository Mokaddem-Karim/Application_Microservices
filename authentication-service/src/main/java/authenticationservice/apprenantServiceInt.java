package authenticationservice;



import java.util.List;
import java.util.Optional;

public interface apprenantServiceInt {

    public Apprenant ajouterApprenant(Apprenant a);
    public Optional<Apprenant> getAppById(int a);
    public List<Apprenant> getAllApprenant();
    public String supprimerApp(int id);
    public Apprenant modifierApp(Apprenant a, int id);


    public Apprenant findAppByEmail(String email) ;


}
