package com.example.gestionstage.mapper;

import com.example.gestionstage.dto.PostulationDTO;
import com.example.gestionstage.entites.Postulation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostulationMapper {
    private StageMapper stageMapper;
    private EtudiantMapper etudiantMapper;

    public PostulationDTO fromPostulation(Postulation postulation) {
        PostulationDTO postulationDTO = new PostulationDTO();
        BeanUtils.copyProperties(postulation, postulationDTO);
        postulationDTO.setStageDTO(stageMapper.fromStage(postulation.getStage()));
        postulationDTO.setEtudiantDTO(etudiantMapper.fromEtudiant(postulation.getEtudiant()));
        return postulationDTO;
    }

    public Postulation fromPostulationDTO(PostulationDTO postulationDTO) {
        Postulation postulation = new Postulation();
        BeanUtils.copyProperties(postulationDTO, postulation);
        postulation.setStage(stageMapper.fromStageDTO(postulationDTO.getStageDTO()));
        postulation.setEtudiant(etudiantMapper.fromEtudiantDTO(postulationDTO.getEtudiantDTO()));
        return postulation;
    }
}
