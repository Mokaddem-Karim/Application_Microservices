package com.linsoft.specialite;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="specialiteF")
public class specialiteF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contenu;
    private int idFormation;

}
