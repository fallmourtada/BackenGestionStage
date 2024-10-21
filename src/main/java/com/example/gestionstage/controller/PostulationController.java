package com.example.gestionstage.controller;

import com.example.gestionstage.Exception.EtudiantNotFoundException;
import com.example.gestionstage.Exception.PostulationNotFoundException;
import com.example.gestionstage.Exception.StageNotFoundException;
import com.example.gestionstage.dto.PostulationDTO;
import com.example.gestionstage.dto.PostulerStageDTO;
import com.example.gestionstage.services.postulationService.PostulationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class PostulationController {
    private PostulationService postulationService;

    @PostMapping("/postulation/stage")
    public PostulationDTO PostulerStage(@RequestBody PostulerStageDTO postulerStageDTO) throws StageNotFoundException, EtudiantNotFoundException {
       return postulationService.PostulerStage(postulerStageDTO);
    }

    @GetMapping("/postulations")
    public List<PostulationDTO> getPostulationList(){
        return postulationService.getListPostulation();
    }

    @PostMapping("/postulations/valider/{postulationId}")
    public void validerPostulation(@PathVariable Long postulationId) throws PostulationNotFoundException {
         postulationService.validerDemande(postulationId);
    }

    @PostMapping("/postulations/annuler/{postulationId}")
    public void annulerPostulation(@PathVariable Long postulationId) throws PostulationNotFoundException {
        postulationService.annulerDemande(postulationId);
    }

    @GetMapping("/postulations/valider")
    public List<PostulationDTO> getPostulationListValider(){
        return postulationService.getListPostulationValider();
    }

    @GetMapping("/postulations/annuler")
    public List<PostulationDTO> getPostulationListAnnuler(){
        return postulationService.getListPostulerAnnuler();
    }
}
