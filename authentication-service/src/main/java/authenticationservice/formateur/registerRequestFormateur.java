package authenticationservice.formateur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class registerRequestFormateur {
    private int matricule;
    private String nom;
    private String prenom;
    private String specialite;
    private String email;
    private String password;
    private String dateN;
    private int tel;
    private String adresse;
}
