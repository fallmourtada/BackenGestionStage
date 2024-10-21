package com.example.gestionstage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RapportDTO {
    private Long id;
    private String titre;
    private String contenu;
    private LocalDate date;
    private StageDTO stageDTO;


}
