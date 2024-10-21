package com.example.gestionstage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddEvaluationDTO {
    private Long evaluationId;
    private Long stageId;

    private Long rapportId;

    private double note;

    private LocalDate date;

    private String commentaire;

}
