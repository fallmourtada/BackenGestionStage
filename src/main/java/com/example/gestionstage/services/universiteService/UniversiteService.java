package com.example.gestionstage.services.universiteService;

import com.example.gestionstage.dto.UniversiteDTO;

import java.util.List;

public interface UniversiteService {

    public UniversiteDTO addUniversite(UniversiteDTO universiteDTO);

    public UniversiteDTO updateUniversite(UniversiteDTO universiteDTO,Long universiteId);

    public void deleteUniversite(Long universiteId);

    public UniversiteDTO getUniversite(Long universiteId);

    public List<UniversiteDTO> getAllUniversites();
}
