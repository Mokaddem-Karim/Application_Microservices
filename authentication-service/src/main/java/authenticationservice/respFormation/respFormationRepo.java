package authenticationservice.respFormation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface respFormationRepo extends JpaRepository<respFormation,Integer> {

     Optional<respFormation> findOneByEmailAndPassword(String email, String password);

     respFormation getRespFormationByEmail(String email);

}
