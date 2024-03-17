package authenticationservice.respInventaire;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface respInventaireRepo extends JpaRepository<respInventaire,Integer> {

     Optional<respInventaire> findOneByEmailAndPassword(String email, String password);

     respInventaire getRespInventaireByEmail(String email);

}
