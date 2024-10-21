package com.example.gestionstage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@DiscriminatorValue("ETUDIANT")
public class Etudiant extends User{
    private Long codePermanent;
    private String niveau;

    @ManyToOne
    @JoinColumn(name = "universite_id")
    private Universite universite;

    @OneToMany(mappedBy = "etudiant",cascade = CascadeType.ALL)
    private List<Postulation> postulations;
}
