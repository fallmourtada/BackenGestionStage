package com.example.gestionstage.mapper;

import com.example.gestionstage.dto.StageDTO;
import com.example.gestionstage.entites.Stage;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StageMapper {
    private EntrepriseMapper entrepriseMapper;

    public StageDTO fromStage(Stage stage) {
        StageDTO stageDTO = new StageDTO();
        BeanUtils.copyProperties(stage, stageDTO);
        stageDTO.setEntrepriseDTO(entrepriseMapper.fromEntreprise(stage.getEntreprise()));
        return stageDTO;
    }

    public Stage fromStageDTO(StageDTO stageDTO) {
        Stage stage = new Stage();
        BeanUtils.copyProperties(stageDTO, stage);
        stage.setEntreprise(entrepriseMapper.fromEntrepriseDTO(stageDTO.getEntrepriseDTO()));
        return stage;
    }


}
