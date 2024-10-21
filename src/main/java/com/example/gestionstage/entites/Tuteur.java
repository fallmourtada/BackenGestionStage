package com.example.gestionstage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@DiscriminatorValue("TUTEUR")
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Tuteur extends User{
    private String specialite;
    private String password;
    @OneToMany(mappedBy = "tuteur",cascade = CascadeType.ALL)
    private List<Supervision> supervisions;
}
