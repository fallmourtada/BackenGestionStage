package com.example.gestionstage.services.rapportService;

import com.example.gestionstage.Exception.StageNotFoundException;
import com.example.gestionstage.dto.AddRapportDTO;
import com.example.gestionstage.dto.RapportDTO;

import java.util.List;

public interface RapportService {

    public List<RapportDTO> getRapports();

    public RapportDTO getRapportById(Long rapportId);

    public RapportDTO createRapport(AddRapportDTO addRapportDTO) throws StageNotFoundException;
    public RapportDTO updateRapport(RapportDTO rapportDTO,Long rapportId );

    public void deleteRapport(Long rapportId);
}
