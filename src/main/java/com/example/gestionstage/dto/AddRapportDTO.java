package com.example.gestionstage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddRapportDTO {
    private Long id;
    private String titre;
    private String contenu;
    private Long stageId;
    private LocalDate date;
}
