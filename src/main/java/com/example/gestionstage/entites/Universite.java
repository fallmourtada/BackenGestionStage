package com.example.gestionstage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Universite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String addresse;
    private String email;
    private String telephone;
    @OneToMany(mappedBy = "universite",cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;
}
