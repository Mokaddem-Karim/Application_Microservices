package authenticationservice.respFormation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class respFormationServiceImpl implements respFormationServiceInt {


    @Autowired
    private respFormationRepo ri;



    @Override
    public respFormation ajouterRespFor(respFormation r) {
        return ri.save(r);
    }

    @Override
    public Optional<respFormation> getRespForById(int id) {
        return ri.findById(id);
    }

    public respFormation findRespForByEmail(String email){return ri.getRespFormationByEmail(email) ;}



    @Override
    public List<respFormation> getAllRespFor() {
        return ri.findAll();
    }

    @Override
    public String supprimerRespFor(int id) {
        ri.deleteById(id);
        return "suppression avec succée";
    }

    @Override
    public respFormation modifierRespFor(respFormation a, int id) {
        return ri.findById(id).map(r -> {
            r.setMatricule(a.getMatricule());
            r.setNom(a.getNom());
            r.setPrenom(a.getPrenom());
            r.setDateN(a.getDateN());
            r.setEmail(a.getEmail());
            r.setPassword(a.getPassword());
            r.setTel(a.getTel());
            return ri.save(r);
        }).orElseThrow(() -> new RuntimeException("responsable formation inexistant !"));
    }



}
