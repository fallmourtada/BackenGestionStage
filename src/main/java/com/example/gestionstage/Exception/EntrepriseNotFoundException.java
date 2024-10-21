package com.example.gestionstage.Exception;

import org.springframework.data.jpa.repository.JpaRepository;

public class EntrepriseNotFoundException extends Exception {

    public EntrepriseNotFoundException(String message){
        super(message);
    }
}
