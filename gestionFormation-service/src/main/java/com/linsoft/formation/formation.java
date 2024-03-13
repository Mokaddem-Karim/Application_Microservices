package com.linsoft.formation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="formation")
@NoArgsConstructor
public class formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String img;
    private String lib;
    private String date;
    private String chargeHoraire;
    private String lieu;
    private boolean arriver;

    public formation(int id, String img, String lib, String date, String chargeHoraire, String lieu) {
        this.id = id;
        this.img = img;
        this.lib = lib;
        this.date = date;
        this.chargeHoraire = chargeHoraire;
        this.lieu = lieu;
        this.arriver=false;
    }
}
