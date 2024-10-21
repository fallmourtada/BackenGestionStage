package com.example.gestionstage.services.evaluationService;

import com.example.gestionstage.dto.AddEvaluationDTO;
import com.example.gestionstage.dto.EvaluationDTO;
import com.example.gestionstage.dto.RapportDTO;
import com.example.gestionstage.dto.StageDTO;
import com.example.gestionstage.entites.Evaluation;
import com.example.gestionstage.entites.Rapport;
import com.example.gestionstage.entites.Stage;
import com.example.gestionstage.mapper.EvaluationMapper;
import com.example.gestionstage.mapper.RapportMapper;
import com.example.gestionstage.mapper.StageMapper;
import com.example.gestionstage.repositories.EvaluationRepository;
import com.example.gestionstage.repositories.RapportRepository;
import com.example.gestionstage.repositories.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService{
    private EvaluationRepository evaluationRepository;
    private EvaluationMapper evaluationMapper;
    private RapportRepository rapportRepository;
    private StageRepository stageRepository;
    private StageMapper stageMapper;
    private RapportMapper rapportMapper;

    @Override
    public List<EvaluationDTO> getEvaluations() {
        List<Evaluation> evaluationList=evaluationRepository.findAll();
        List<EvaluationDTO> evaluationDTOList= evaluationList.stream().map(evaluation ->evaluationMapper.fromEvaluation(evaluation))
                .collect(Collectors.toList());
        return evaluationDTOList;
    }

    @Override
    public EvaluationDTO getEvaluationById(Long evaluationId) {
        Evaluation evaluation=evaluationRepository.findById(evaluationId).orElse(null);
        EvaluationDTO evaluationDTO=evaluationMapper.fromEvaluation(evaluation);
        return evaluationDTO;
    }

    @Override
    public EvaluationDTO saveEvaluation(AddEvaluationDTO addEvaluationDTO) {
        Long rapportId=addEvaluationDTO.getRapportId();
        Long stageId=addEvaluationDTO.getStageId();
        Rapport rapport=rapportRepository.findById(rapportId).orElse(null);
        Stage stage=stageRepository.findById(stageId).orElse(null);
        RapportDTO rapportDTO=rapportMapper.fromRapport(rapport);
        StageDTO stageDTO=stageMapper.fromStage(stage);

        EvaluationDTO evaluationDTO=new EvaluationDTO();
        evaluationDTO.setNote(addEvaluationDTO.getNote());
        evaluationDTO.setDate(addEvaluationDTO.getDate());
        evaluationDTO.setCommentaire(addEvaluationDTO.getCommentaire());
        evaluationDTO.setStageDTO(stageDTO);
        evaluationDTO.setRapportDTO(rapportDTO);
        Evaluation evaluation=evaluationMapper.fromEvaluation(evaluationDTO);
        evaluation.setRapport(rapport);
        evaluation.setStage(stage);
        Evaluation evaluation1=evaluationRepository.save(evaluation);
        return evaluationMapper.fromEvaluation(evaluation1);
    }
}
