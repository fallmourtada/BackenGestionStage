package com.example.gestionstage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostulerStageDTO {
    private Long stageId;
    private String nom;
    private String prenom;
    private String email;
    private String niveau;
    //private Long etudiantId;
}
