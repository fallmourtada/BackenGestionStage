package com.example.gestionstage.controller;

import com.example.gestionstage.dto.EtudiantDTO;
import com.example.gestionstage.dto.TuteurDTO;
import com.example.gestionstage.services.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class TuteurController {
    private UserService userService;

   @GetMapping("/tuteurs")
    public List<TuteurDTO> getAllTuteurs(){
     return userService.getAllTuteurs();
   }


    @PostMapping("/tuteurs")
    public TuteurDTO saveTuteur(@RequestBody TuteurDTO tuteurDTO){
       return userService.ajouterTuteur(tuteurDTO);
    }

    @DeleteMapping("/tuteurs/{tuteurId}")
    public void deleteTuteur(@PathVariable Long tuteurId){
       userService.deleteTuteur(tuteurId);
    }
}
