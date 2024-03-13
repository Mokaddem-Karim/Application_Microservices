package authenticationservice.formateur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface formateurRepo extends JpaRepository<Formateur,Integer> {

    Optional<Formateur> findOneByEmailAndPassword(String email, String password);

    Formateur getFormateurByEmail(String email);
}
