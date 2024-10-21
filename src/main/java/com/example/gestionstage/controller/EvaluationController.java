package com.example.gestionstage.controller;

import com.example.gestionstage.dto.AddEvaluationDTO;
import com.example.gestionstage.dto.EvaluationDTO;
import com.example.gestionstage.services.evaluationService.EvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class EvaluationController {
    private EvaluationService evaluationService;

    @GetMapping("/evaluations")
    public List<EvaluationDTO> getAllEvaluations() {
        return evaluationService.getEvaluations();
    }

    @GetMapping("/evaluations/{evaluationI}")
    public EvaluationDTO getEvaluationById(@PathVariable Long evaluationId) {
        return evaluationService.getEvaluationById(evaluationId);
    }

    @PostMapping("/evaluations")
    public EvaluationDTO saveEvaluation(@RequestBody AddEvaluationDTO addEvaluationDTO) {
        return evaluationService.saveEvaluation(addEvaluationDTO);
    }
}
