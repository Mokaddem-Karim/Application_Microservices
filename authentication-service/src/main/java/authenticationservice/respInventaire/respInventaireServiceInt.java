package authenticationservice.respInventaire;



import java.util.List;
import java.util.Optional;

public interface respInventaireServiceInt {

    public respInventaire ajouterRespInv(respInventaire a);
    public Optional<respInventaire> getRespInvById(int a);
    public List<respInventaire> getAllRespInv();
    public String supprimerRespInv(int id);
    public respInventaire modifierRespInv(respInventaire a, int id);


    public respInventaire findRespInvByEmail(String email) ;


}
