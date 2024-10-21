package com.example.gestionstage.services.entrepriseService;

import com.example.gestionstage.dto.EntrepriseDTO;
import com.example.gestionstage.entites.Entreprise;
import com.example.gestionstage.mapper.EntrepriseMapper;
import com.example.gestionstage.repositories.EntrepriseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;
    private EntrepriseMapper entrepriseMapper;

    @Override
    public EntrepriseDTO save(EntrepriseDTO entrepriseDTO) {
        Entreprise entreprise=entrepriseMapper.fromEntrepriseDTO(entrepriseDTO);
        Entreprise entreprise1=entrepriseRepository.save(entreprise);
        return entrepriseMapper.fromEntreprise(entreprise1);

    }

    @Override
    public List<EntrepriseDTO> findAll() {
        List<Entreprise> entrepriseList=entrepriseRepository.findAll();
        List<EntrepriseDTO> entrepriseDTOList=entrepriseList.stream().map(entreprise -> entrepriseMapper.fromEntreprise(entreprise))
                .collect(Collectors.toList());
        return entrepriseDTOList;
    }

    @Override
    public EntrepriseDTO findById(Long id) {
        Entreprise entreprise=entrepriseRepository.findById(id).orElse(null);
        return entrepriseMapper.fromEntreprise(entreprise);
    }

    @Override
    public void delete(Long id) {
        entrepriseRepository.deleteById(id);
        log.info("Entreprise Deleted Succesfully");

    }
}
