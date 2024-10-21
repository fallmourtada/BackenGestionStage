package com.example.gestionstage.controller;

import com.example.gestionstage.dto.UniversiteDTO;
import com.example.gestionstage.services.universiteService.UniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class UniversiteController {
    private UniversiteService universiteService;

    @GetMapping("/universites")
    public List<UniversiteDTO> getUniversite(){
        return  universiteService.getAllUniversites();
    }

    @PostMapping("/universites")
    public UniversiteDTO saveUniversite(@RequestBody UniversiteDTO universiteDTO){
        return universiteService.addUniversite(universiteDTO);
    }

    @GetMapping("/universites/{universiteId}")
    public UniversiteDTO getUniversiteById(@PathVariable Long universiteId){
        return universiteService.getUniversite(universiteId);
    }

    @DeleteMapping("/universites/{universiteId}")
    public void deleteUniversite(@PathVariable Long universiteId){
        universiteService.deleteUniversite(universiteId);
    }

}
