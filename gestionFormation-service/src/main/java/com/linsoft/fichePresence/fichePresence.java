package com.linsoft.fichePresence;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="fichePresence")
public class fichePresence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idAF;
    private String date;
    private String etat; //présent ou abscent
}
