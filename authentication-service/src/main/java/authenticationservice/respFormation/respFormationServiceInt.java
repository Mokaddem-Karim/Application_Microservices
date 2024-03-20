package authenticationservice.respFormation;



import java.util.List;
import java.util.Optional;

public interface respFormationServiceInt {

    public respFormation ajouterRespFor(respFormation a);
    public Optional<respFormation> getRespForById(int a);
    public List<respFormation> getAllRespFor();
    public String supprimerRespFor(int id);
    public respFormation modifierRespFor(respFormation a, int id);


    public respFormation findRespForByEmail(String email) ;


}
