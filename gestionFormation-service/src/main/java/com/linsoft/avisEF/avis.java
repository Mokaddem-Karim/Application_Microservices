package com.linsoft.avisEF;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="avis")
@AllArgsConstructor
@NoArgsConstructor
public class avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String details;
    private float note;
    private int idFormation;
    private int idApprenant;

}
