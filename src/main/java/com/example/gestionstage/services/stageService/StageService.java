package com.example.gestionstage.services.stageService;

import com.example.gestionstage.Exception.EntrepriseNotFoundException;
import com.example.gestionstage.dto.AddStageDTO;
import com.example.gestionstage.dto.StageDTO;

import java.util.List;

public interface StageService {
    public StageDTO saveStage(AddStageDTO addStageDTO) throws EntrepriseNotFoundException;

    public List<StageDTO> getAllStage();

    public StageDTO getStageById(Long stageId);

    public void deleteStage(Long stageId);
}
