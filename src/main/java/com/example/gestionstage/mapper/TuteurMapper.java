package com.example.gestionstage.mapper;

import com.example.gestionstage.dto.TuteurDTO;
import com.example.gestionstage.entites.Tuteur;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TuteurMapper {

    public Tuteur fromTuteurDTO(TuteurDTO tuteurDTO) {
        Tuteur tuteur = new Tuteur();
        BeanUtils.copyProperties(tuteurDTO, tuteur);
        return tuteur;
    }

    public TuteurDTO fromTuteur(Tuteur tuteur) {
        TuteurDTO tuteurDTO = new TuteurDTO();
        BeanUtils.copyProperties(tuteur, tuteurDTO);
        return tuteurDTO;
    }
}
