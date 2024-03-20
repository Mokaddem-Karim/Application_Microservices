package authenticationservice.respFormation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class registerRequestRespFormation {
    private int matricule;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String dateN;
    private int tel;
    private String adresse;

}
