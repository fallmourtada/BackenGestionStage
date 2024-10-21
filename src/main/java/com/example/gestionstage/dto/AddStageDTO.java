package com.example.gestionstage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddStageDTO {
    private Long stageId;
    private String titre;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Long entrepriseId;
}
