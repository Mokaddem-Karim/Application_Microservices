package com.linsoft.apprenantFormation;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="apprenantFormation")
public class apprenantFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idFormation;
    private int idApprenant;
    private int idGrilleEva;
    private int idFichePresence;

}
