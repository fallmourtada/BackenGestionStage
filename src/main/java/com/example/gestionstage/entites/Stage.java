package com.example.gestionstage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Stage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @OneToMany(mappedBy = "stage",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postulation> postulations;

    @ManyToOne
    private Entreprise entreprise;

    @OneToMany(mappedBy = "stage",cascade = CascadeType.ALL)
    private List<Rapport> rapports;

    @OneToMany(mappedBy = "stage",cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "stage",cascade = CascadeType.ALL)
    private List<Supervision> supervisions;

}
