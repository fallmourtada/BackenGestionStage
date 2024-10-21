package com.example.gestionstage.controller;

import com.example.gestionstage.Exception.EntrepriseNotFoundException;
import com.example.gestionstage.dto.AddStageDTO;
import com.example.gestionstage.dto.StageDTO;
import com.example.gestionstage.services.stageService.StageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class StageController {
    private StageService stageService;

    @GetMapping("/stages")
    public List<StageDTO> getListStage(){
        return stageService.getAllStage();
    }

    @PostMapping("/stages")
    public StageDTO ajouterStage(@RequestBody AddStageDTO addStageDTO) throws EntrepriseNotFoundException {
        return stageService.saveStage(addStageDTO);
    }

    @GetMapping("/stages/{stageId}")
    public StageDTO getStageById(@PathVariable Long stageId){
        return stageService.getStageById(stageId);
    }

    @DeleteMapping("/stages/{stageId}")
    public void deleteStage(@PathVariable Long stageId){
        stageService.deleteStage(stageId);
    }
}
