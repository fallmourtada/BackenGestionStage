package com.example.gestionstage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EvaluationDTO {
    private Long id;

    private String commentaire;

    private double note;

    private LocalDate date;

    private RapportDTO rapportDTO;

    private StageDTO stageDTO;
}
