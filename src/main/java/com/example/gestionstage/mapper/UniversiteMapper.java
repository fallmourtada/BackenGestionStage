package com.example.gestionstage.mapper;

import com.example.gestionstage.dto.UniversiteDTO;
import com.example.gestionstage.entites.Universite;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UniversiteMapper {

    public UniversiteDTO fromUniversite(Universite universite) {
        UniversiteDTO universiteDTO = new UniversiteDTO();
        BeanUtils.copyProperties(universite, universiteDTO);
        return universiteDTO;
    }

    public Universite fromUniversiteDTO(UniversiteDTO universiteDTO) {
        Universite universite = new Universite();
        BeanUtils.copyProperties(universiteDTO, universite);
        return universite;
    }
}
