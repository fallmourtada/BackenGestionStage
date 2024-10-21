package com.example.gestionstage.services.universiteService;

import com.example.gestionstage.dto.UniversiteDTO;
import com.example.gestionstage.entites.Universite;
import com.example.gestionstage.mapper.UniversiteMapper;
import com.example.gestionstage.repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UniversiteServiceImpl implements UniversiteService{
    private UniversiteRepository universiteRepository;
    private UniversiteMapper universiteMapper;
    @Override
    public UniversiteDTO addUniversite(UniversiteDTO universiteDTO) {
        Universite universite=universiteMapper.fromUniversiteDTO(universiteDTO);
        Universite universite1=universiteRepository.save(universite);
        return universiteMapper.fromUniversite(universite1);
    }

    @Override
    public UniversiteDTO updateUniversite(UniversiteDTO universiteDTO, Long universiteId) {
        return null;
    }

    @Override
    public void deleteUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
        log.info("Universite deleted Successfully");

    }

    @Override
    public UniversiteDTO getUniversite(Long universiteId) {
        Universite universite=universiteRepository.findById(universiteId).orElse(null);
        UniversiteDTO universiteDTO=universiteMapper.fromUniversite(universite);
        return universiteDTO;
    }

    @Override
    public List<UniversiteDTO> getAllUniversites() {
        List<Universite> universiteList=universiteRepository.findAll();
        List<UniversiteDTO> universiteDTOList=universiteList.stream().map(universite -> universiteMapper.fromUniversite(universite))
                .collect(Collectors.toList());
        return universiteDTOList;
    }
}
