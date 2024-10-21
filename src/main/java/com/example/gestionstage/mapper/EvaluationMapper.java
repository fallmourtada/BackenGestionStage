package com.example.gestionstage.mapper;

import com.example.gestionstage.dto.EvaluationDTO;
import com.example.gestionstage.entites.Evaluation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EvaluationMapper {
    private StageMapper stageMapper;
    private RapportMapper rapportMapper;

    public Evaluation fromEvaluation(EvaluationDTO evaluationDTO){
        Evaluation evaluation = new Evaluation();
        BeanUtils.copyProperties(evaluationDTO, evaluation);
        evaluation.setStage(stageMapper.fromStageDTO(evaluationDTO.getStageDTO()));
        evaluation.setRapport(rapportMapper.fromRapportDTO(evaluationDTO.getRapportDTO()));
        return evaluation;


    }

    public EvaluationDTO fromEvaluation(Evaluation evaluation){
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        BeanUtils.copyProperties(evaluation, evaluationDTO);
        evaluationDTO.setStageDTO(stageMapper.fromStage(evaluation.getStage()));
        evaluationDTO.setRapportDTO(rapportMapper.fromRapport(evaluation.getRapport()));
        return evaluationDTO;


    }
}
