package com.example.gestionstage.controller;

import com.example.gestionstage.Exception.UniversiteNotFoundException;
import com.example.gestionstage.dto.AddEtudiantDTO;
import com.example.gestionstage.dto.EtudiantDTO;
import com.example.gestionstage.services.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class EtudiantControlller {
    private UserService userService;

    @GetMapping("/etudiants")
    public List<EtudiantDTO> getListEtudiant(){
        return userService.getAllEtudiants();
    }

    @PostMapping("/etudiants")
    public EtudiantDTO saveEtudiant(@RequestBody AddEtudiantDTO addEtudiantDTO) throws UniversiteNotFoundException {
        return  userService.ajouterEtudiant(addEtudiantDTO);
    }

    @DeleteMapping("/etudiants/{etudiantId}")
    public void deleteEtudiant(@PathVariable Long etudiantId){
        userService.deleteEtudiant(etudiantId);
    }
}
