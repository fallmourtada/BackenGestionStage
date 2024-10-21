package com.example.gestionstage.services.rapportService;

import com.example.gestionstage.Exception.StageNotFoundException;
import com.example.gestionstage.dto.AddRapportDTO;
import com.example.gestionstage.dto.RapportDTO;
import com.example.gestionstage.entites.Rapport;
import com.example.gestionstage.entites.Stage;
import com.example.gestionstage.mapper.RapportMapper;
import com.example.gestionstage.mapper.StageMapper;
import com.example.gestionstage.repositories.RapportRepository;
import com.example.gestionstage.repositories.StageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class RapportServiceImpl implements RapportService {
    private final StageMapper stageMapper;
    private RapportRepository rapportRepository;
    private RapportMapper rapportMapper;
    private StageRepository stageRepository;
    @Override
    public List<RapportDTO> getRapports() {
        List<Rapport> rapports = rapportRepository.findAll();
        List<RapportDTO> rapportDTOList=rapports.stream().map(rapport -> rapportMapper.fromRapport(rapport))
                .collect(Collectors.toList());
        return rapportDTOList;
    }

    @Override
    public RapportDTO getRapportById(Long rapportId) {
        Rapport rapport = rapportRepository.findById(rapportId).orElse(null);
       return  rapportMapper.fromRapport(rapport);
    }

    @Override
    public RapportDTO createRapport(AddRapportDTO addRapportDTO) throws StageNotFoundException {
        RapportDTO rapportDTO=new RapportDTO();
        Long stageId=addRapportDTO.getStageId();
        Stage stage=stageRepository.findById(stageId)
                .orElseThrow(()->new StageNotFoundException("Stage Not Found with id"+stageId));
        rapportDTO.setDate(LocalDate.now());
        rapportDTO.setTitre(addRapportDTO.getTitre());
        rapportDTO.setContenu(addRapportDTO.getContenu());
        rapportDTO.setStageDTO(stageMapper.fromStage(stage));
        Rapport rapport=rapportMapper.fromRapportDTO(rapportDTO);
        rapport.setStage(stage);
        Rapport rapport1=rapportRepository.save(rapport);
        return rapportMapper.fromRapport(rapport1);
    }

    @Override
    public RapportDTO updateRapport(RapportDTO rapportDTO, Long rapportId) {
        Rapport rapport=rapportRepository.findById(rapportId).orElse(null);

        return null;
    }

    @Override
    public void deleteRapport(Long rapportId) {
        rapportRepository.deleteById(rapportId);
        log.info("Rapport Deleted Successfully");

    }
}
