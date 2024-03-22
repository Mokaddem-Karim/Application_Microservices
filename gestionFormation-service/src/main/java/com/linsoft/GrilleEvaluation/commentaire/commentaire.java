package com.linsoft.GrilleEvaluation.commentaire;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="commentaire")
public class commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  contenu;
    private int idSection;
}
