package com.example.gestionstage.services.evaluationService;

import com.example.gestionstage.dto.AddEvaluationDTO;
import com.example.gestionstage.dto.EvaluationDTO;

import java.util.List;

public interface EvaluationService {
    public List<EvaluationDTO> getEvaluations();

    public EvaluationDTO getEvaluationById(Long evaluationId);

    public EvaluationDTO saveEvaluation(AddEvaluationDTO addEvaluationDTO);
}
