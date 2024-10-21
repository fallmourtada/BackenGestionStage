package com.example.gestionstage.dto;

import com.example.gestionstage.enumeration.StatusPostulation;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostulationDTO {
    private Long id;

    private LocalDate date;

    private StatusPostulation status;

    private StageDTO stageDTO;

    private EtudiantDTO etudiantDTO;

}
