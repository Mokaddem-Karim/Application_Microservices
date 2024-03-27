package authenticationservice.formateur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface formateurRepo extends JpaRepository<Formateur,Integer> {

    Optional<Formateur> findOneByEmailAndPassword(String email, String password);

    Optional<Formateur> findFormateurByMatricule(int matricule);

    List<Formateur> findFormateurBySpecialite(String spec);


    Formateur getFormateurByEmail(String email);
}
