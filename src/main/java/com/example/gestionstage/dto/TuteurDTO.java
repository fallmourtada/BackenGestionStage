package com.example.gestionstage.dto;

import lombok.Data;

@Data
public class TuteurDTO extends UserDTO{
    private Long id;
    private String specialite;
    private String password;


}
