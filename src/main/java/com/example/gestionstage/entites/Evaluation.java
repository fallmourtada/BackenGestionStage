package com.example.gestionstage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class Evaluation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentaire;

    private double note;

    private LocalDate date;

//    @ManyToOne
//    private Stage stage;

    @ManyToOne
    private Stage stage;

    @ManyToOne
    private Rapport rapport;
}
