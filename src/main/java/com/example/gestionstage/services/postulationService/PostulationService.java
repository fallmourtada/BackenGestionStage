package com.example.gestionstage.services.postulationService;

import com.example.gestionstage.Exception.EtudiantNotFoundException;
import com.example.gestionstage.Exception.PostulationNotFoundException;
import com.example.gestionstage.Exception.StageNotFoundException;
import com.example.gestionstage.dto.PostulationDTO;
import com.example.gestionstage.dto.PostulerStageDTO;

import java.util.List;

public interface PostulationService {
    public PostulationDTO PostulerStage(PostulerStageDTO postulerStageDTO) throws EtudiantNotFoundException, StageNotFoundException;

    public List<PostulationDTO> getListPostulation();

    public void validerDemande(Long postulationId) throws PostulationNotFoundException;

    public void annulerDemande(Long postulationId ) throws PostulationNotFoundException;

    public List<PostulationDTO> getListPostulationValider();

    public List<PostulationDTO> getListPostulerAnnuler();
}
