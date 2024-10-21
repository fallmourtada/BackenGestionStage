package com.example.gestionstage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StageDTO {
    private Long id;
    private String titre;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private EntrepriseDTO entrepriseDTO;


}
