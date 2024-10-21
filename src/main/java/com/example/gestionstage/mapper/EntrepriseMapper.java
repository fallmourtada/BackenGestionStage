package com.example.gestionstage.mapper;

import com.example.gestionstage.dto.EntrepriseDTO;
import com.example.gestionstage.entites.Entreprise;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntrepriseMapper {

    public EntrepriseDTO fromEntreprise(Entreprise entreprise) {
        EntrepriseDTO entrepriseDTO = new EntrepriseDTO();
        BeanUtils.copyProperties(entreprise, entrepriseDTO);
        return entrepriseDTO;
    }

    public Entreprise fromEntrepriseDTO(EntrepriseDTO entrepriseDTO) {
        Entreprise entreprise = new Entreprise();
        BeanUtils.copyProperties(entrepriseDTO, entreprise);
        return entreprise;
    }
}
