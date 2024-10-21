package com.example.gestionstage.services.entrepriseService;

import com.example.gestionstage.dto.EntrepriseDTO;

import java.util.List;

public interface EntrepriseService {
    public EntrepriseDTO save(EntrepriseDTO entrepriseDTO);

    public List<EntrepriseDTO> findAll();

    public EntrepriseDTO findById(Long id);

    public void delete(Long id);
}
