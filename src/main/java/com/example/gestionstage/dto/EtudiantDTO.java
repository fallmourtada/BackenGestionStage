package com.example.gestionstage.dto;

import lombok.Data;

@Data
public class EtudiantDTO extends UserDTO{
    private Long id;

    private Long codePermanent;

    private String niveau;

    private UniversiteDTO universiteDTO;


}
