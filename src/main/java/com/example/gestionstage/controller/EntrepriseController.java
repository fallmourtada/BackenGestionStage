package com.example.gestionstage.controller;


import com.example.gestionstage.dto.EntrepriseDTO;
import com.example.gestionstage.services.entrepriseService.EntrepriseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
public class EntrepriseController {
    private EntrepriseService entrepriseService;

    @PostMapping("/entreprise")
    public EntrepriseDTO saveEntreprise(@RequestBody EntrepriseDTO entrepriseDTO){
        return entrepriseService.save(entrepriseDTO);
    }

    @GetMapping("/entreprise")
    public List<EntrepriseDTO> getAllEntreprise(){
        return entrepriseService.findAll();
    }

    @GetMapping("/entreprise/{entrepriseId}")
    public EntrepriseDTO getEntrepriseById(@PathVariable Long entrepriseId){
        return entrepriseService.findById(entrepriseId);
    }

    @DeleteMapping("/entreprise/{entrepriseId}")
    public void deleteEntreprise(@PathVariable Long entrepriseId){
        entrepriseService.delete(entrepriseId);
    }

}
