package com.example.gestionstage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Rapport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String contenu;
    private LocalDate date;

    @ManyToOne
    private Stage stage;
}
