package com.example.gestionstage.dto;

import lombok.Data;

@Data
public class AddEtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String niveau;
    private Long codePermanent;
    private Long universiteId;

}
