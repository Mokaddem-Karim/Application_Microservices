package com.linsoft.formation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity

@NoArgsConstructor
@Data
@Table(name="formation")
public class formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgSrc;
    private String lib;
    private String dateD;
    private String dateF;
    private String dureeJ;
    private String type;
    private String lieu;
    private String formateurNP;
    private boolean disponible; //si formation faite alors disponible sera mis à false

    public formation(int id, String imgSrc, String lib, String dateD, String dateF, String dureeJ,String type,String lieu,String formateurNP) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.lib = lib;
        this.dateD = dateD;
        this.dateF = dateF;
        this.dureeJ = dureeJ;
        this.type=type;
        this.lieu=lieu;
        this.formateurNP=formateurNP;
        this.disponible=true;
    }

}
