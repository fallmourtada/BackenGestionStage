package com.example.gestionstage.mapper;

import com.example.gestionstage.dto.RapportDTO;
import com.example.gestionstage.entites.Rapport;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RapportMapper {
    private StageMapper stageMapper;

    public Rapport fromRapportDTO(RapportDTO rapportDTO) {
        Rapport rapport = new Rapport();
        BeanUtils.copyProperties(rapportDTO, rapport);
        rapport.setStage(stageMapper.fromStageDTO(rapportDTO.getStageDTO()));
        return rapport;
    }

    public RapportDTO fromRapport(Rapport rapport) {
        RapportDTO rapportDTO = new RapportDTO();
        BeanUtils.copyProperties(rapport, rapportDTO);
        rapportDTO.setStageDTO(stageMapper.fromStage(rapport.getStage()));
        return rapportDTO;
    }
}
