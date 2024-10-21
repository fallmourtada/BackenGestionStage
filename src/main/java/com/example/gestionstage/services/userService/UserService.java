package com.example.gestionstage.services.userService;

import com.example.gestionstage.Exception.UniversiteNotFoundException;
import com.example.gestionstage.dto.AddEtudiantDTO;
import com.example.gestionstage.dto.EtudiantDTO;
import com.example.gestionstage.dto.TuteurDTO;

import java.util.List;

public interface UserService {

    public EtudiantDTO ajouterEtudiant(AddEtudiantDTO addEtudiantDTO) throws UniversiteNotFoundException;

    public TuteurDTO ajouterTuteur(TuteurDTO tuteurDTO);

    public List<EtudiantDTO> getAllEtudiants();

    public List<TuteurDTO> getAllTuteurs();

    public void deleteEtudiant(Long etudiantId);

    public void deleteTuteur(Long tuteurId);
}
