package com.linsoft.GrilleEvaluation.section;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="section")
public class section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  lib;
    private int idGrille;
}
