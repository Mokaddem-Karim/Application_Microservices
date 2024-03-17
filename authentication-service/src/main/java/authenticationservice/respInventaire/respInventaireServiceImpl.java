package authenticationservice.respInventaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class respInventaireServiceImpl implements respInventaireServiceInt {


    @Autowired
    private respInventaireRepo ri;



    @Override
    public respInventaire ajouterRespInv(respInventaire r) {
        return ri.save(r);
    }

    @Override
    public Optional<respInventaire> getRespInvById(int id) {
        return ri.findById(id);
    }

    public respInventaire findRespInvByEmail(String email){return ri.getRespInventaireByEmail(email) ;}



    @Override
    public List<respInventaire> getAllRespInv() {
        return ri.findAll();
    }

    @Override
    public String supprimerRespInv(int id) {
        ri.deleteById(id);
        return "suppression avec succée";
    }

    @Override
    public respInventaire modifierRespInv(respInventaire a, int id) {
        return ri.findById(id).map(r -> {
            r.setMatricule(a.getMatricule());
            r.setNom(a.getNom());
            r.setPrenom(a.getPrenom());
            r.setDateN(a.getDateN());
            r.setEmail(a.getEmail());
            r.setPassword(a.getPassword());
            r.setTel(a.getTel());
            return ri.save(r);
        }).orElseThrow(() -> new RuntimeException("responsable inexistant !"));
    }



}
