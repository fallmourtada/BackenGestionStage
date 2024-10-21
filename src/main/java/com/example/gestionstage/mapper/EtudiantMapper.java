package com.example.gestionstage.mapper;

import com.example.gestionstage.dto.EtudiantDTO;
import com.example.gestionstage.entites.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EtudiantMapper {
    private UniversiteMapper universiteMapper;

    public Etudiant fromEtudiantDTO(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantDTO, etudiant);
        etudiant.setUniversite(universiteMapper.fromUniversiteDTO(etudiantDTO.getUniversiteDTO()));
        return etudiant;
    }

    public EtudiantDTO fromEtudiant(Etudiant etudiant) {
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(etudiant, etudiantDTO);
        etudiantDTO.setUniversiteDTO(universiteMapper.fromUniversite(etudiant.getUniversite()));
        return etudiantDTO;
    }
}
