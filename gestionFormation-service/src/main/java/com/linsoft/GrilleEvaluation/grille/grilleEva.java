package com.linsoft.GrilleEvaluation.grille;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="grilleEva")
public class grilleEva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idAF;


}
