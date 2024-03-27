package authenticationservice.formateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class formateurServiceImpl implements formateurServiceInt {

    @Autowired
    private formateurRepo fr;



    @Override
    public Formateur ajouterFormateur(Formateur f) {
        return fr.save(f);
    }

    @Override
    public Optional<Formateur> getForById(int id) {
        return fr.findById(id);
    }

    public Formateur findForByEmail(String email){return fr.getFormateurByEmail(email) ;}

    @Override
    public Optional<Formateur> getForByMatricule(int mat) {
        return fr.findFormateurByMatricule(mat);
    }

    @Override
    public List<Formateur> getForBySpecialite(String spec) {
        return fr.findFormateurBySpecialite(spec);
    }



    @Override
    public List<Formateur> getAllFormateur() {
        return fr.findAll();
    }

    @Override
    public String supprimerFor(int id) {
        fr.deleteById(id);
        return "suppression avec succée";
    }

    @Override
    public Formateur modifierFor(Formateur a, int id) {
        return fr.findById(id).map(r -> {
            r.setMatricule(a.getMatricule());
            r.setNom(a.getNom());
            r.setPrenom(a.getPrenom());
            r.setSpecialite(a.getSpecialite());
            r.setDateN(a.getDateN());
            r.setEmail(a.getEmail());
            r.setPassword(a.getPassword());
            r.setTel(a.getTel());
            return fr.save(r);
        }).orElseThrow(() -> new RuntimeException("formateur inexistant !"));
    }


}
