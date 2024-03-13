package authenticationservice.apprenant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface apprenantRepo extends JpaRepository<Apprenant,Integer> {

     Optional<Apprenant> findOneByEmailAndPassword(String email, String password);

     Apprenant getApprenantByEmail(String email);

}
