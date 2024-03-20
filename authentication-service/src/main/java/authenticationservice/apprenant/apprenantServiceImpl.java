package authenticationservice.apprenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class apprenantServiceImpl implements apprenantServiceInt {


    @Autowired
    private apprenantRepo ar;



    @Override
    public Apprenant ajouterApprenant(Apprenant a) {
        return ar.save(a);
    }

    @Override
    public Optional<Apprenant> getAppById(int id) {
        return ar.findById(id);
    }

    public Apprenant findAppByEmail(String email){return ar.getApprenantByEmail(email) ;}



    @Override
    public List<Apprenant> getAllApprenant() {
        return ar.findAll();
    }

    @Override
    public String supprimerApp(int id) {
        ar.deleteById(id);
        return "suppression avec succée";
    }

    @Override
    public Apprenant modifierApp(Apprenant a, int id) {
        return ar.findById(id).map(r -> {
            r.setCin(a.getCin());
            r.setNom(a.getNom());
            r.setPrenom(a.getPrenom());
            r.setDateN(a.getDateN());
            r.setEmail(a.getEmail());
            r.setPassword(a.getPassword());
            r.setTel(a.getTel());
            return ar.save(r);
        }).orElseThrow(() -> new RuntimeException("apprenant inexistant !"));
    }



}
