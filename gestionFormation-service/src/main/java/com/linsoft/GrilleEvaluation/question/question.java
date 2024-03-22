package com.linsoft.GrilleEvaluation.question;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="question")
public class question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  contenu;
    private int note;
    private int idSection;
}
