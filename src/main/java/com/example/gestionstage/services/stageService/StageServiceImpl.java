package com.example.gestionstage.services.stageService;

import com.example.gestionstage.Exception.EntrepriseNotFoundException;
import com.example.gestionstage.dto.AddStageDTO;
import com.example.gestionstage.dto.EntrepriseDTO;
import com.example.gestionstage.dto.StageDTO;
import com.example.gestionstage.entites.Entreprise;
import com.example.gestionstage.entites.Stage;
import com.example.gestionstage.mapper.EntrepriseMapper;
import com.example.gestionstage.mapper.StageMapper;
import com.example.gestionstage.repositories.EntrepriseRepository;
import com.example.gestionstage.repositories.StageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class StageServiceImpl implements StageService {
    private StageMapper stageMapper;
    private StageRepository stageRepository;
    private EntrepriseRepository entrepriseRepository;
    private EntrepriseMapper entrepriseMapper;

    @Override
    public StageDTO saveStage(AddStageDTO addStageDTO) throws EntrepriseNotFoundException {
       Long entrepriseId=addStageDTO.getEntrepriseId();
       Entreprise entreprise=entrepriseRepository.findById(entrepriseId)
               .orElseThrow(()->new EntrepriseNotFoundException("Entreprise with id not found"+addStageDTO.getEntrepriseId()));
       EntrepriseDTO entrepriseDTO=entrepriseMapper.fromEntreprise(entreprise);
       StageDTO stageDTO=new StageDTO();
       stageDTO.setTitre(addStageDTO.getTitre());
       stageDTO.setDescription(addStageDTO.getDescription());
       stageDTO.setDateDebut(addStageDTO.getDateDebut());
       stageDTO.setDateFin(addStageDTO.getDateFin());
       stageDTO.setEntrepriseDTO(entrepriseDTO);
       Stage stage=stageMapper.fromStageDTO(stageDTO);
       stage.setEntreprise(entreprise);
       Stage stage1=stageRepository.save(stage);

        return stageMapper.fromStage(stage1);
    }

    @Override
    public List<StageDTO> getAllStage() {
        List<Stage> stageList=stageRepository.findAll();
        List<StageDTO> stageDTOList=stageList.stream().map(stage -> stageMapper.fromStage(stage))
                .collect(Collectors.toList());
        return stageDTOList;
    }

    @Override
    public StageDTO getStageById(Long stageId) {
        Stage stage=stageRepository.findById(stageId).get();
        StageDTO stageDTO=stageMapper.fromStage(stage);
        return stageDTO;
    }

    @Override
    public void deleteStage(Long stageId) {
        stageRepository.deleteById(stageId);
        log.info("STage Deleted Successfully");

    }
}
