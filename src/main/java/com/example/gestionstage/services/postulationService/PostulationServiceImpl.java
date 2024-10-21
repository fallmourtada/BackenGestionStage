package com.example.gestionstage.services.postulationService;

import com.example.gestionstage.Exception.EtudiantNotFoundException;
import com.example.gestionstage.Exception.PostulationNotFoundException;
import com.example.gestionstage.Exception.StageNotFoundException;
import com.example.gestionstage.dto.EtudiantDTO;
import com.example.gestionstage.dto.PostulationDTO;
import com.example.gestionstage.dto.PostulerStageDTO;
import com.example.gestionstage.dto.StageDTO;
import com.example.gestionstage.entites.Etudiant;
import com.example.gestionstage.entites.Postulation;
import com.example.gestionstage.entites.Stage;
import com.example.gestionstage.enumeration.StatusPostulation;
import com.example.gestionstage.mapper.EtudiantMapper;
import com.example.gestionstage.mapper.PostulationMapper;
import com.example.gestionstage.mapper.StageMapper;
import com.example.gestionstage.repositories.PostulationRepository;
import com.example.gestionstage.repositories.StageRepository;
import com.example.gestionstage.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostulationServiceImpl implements PostulationService {
    private UserRepository userRepository;
    private StageRepository stageRepository;
    private StageMapper stageMapper;
    private EtudiantMapper etudiantMapper;
    private PostulationMapper postulationMapper;
    private PostulationRepository postulationRepository;

    @Override
    public PostulationDTO PostulerStage(PostulerStageDTO postulerStageDTO) throws EtudiantNotFoundException, StageNotFoundException {
        String email=postulerStageDTO.getEmail();
        Etudiant etudiant= userRepository.findEtudiantByEmail(email);
        if(etudiant==null)
            throw new EtudiantNotFoundException("Etudiant Not Found Exception");

        Long stageId=postulerStageDTO.getStageId();
        Stage stage=stageRepository.findById(stageId)
                        .orElseThrow(()->new StageNotFoundException("Stage not found"));
        PostulationDTO postulationDTO=new PostulationDTO();
        EtudiantDTO etudiantDTO=etudiantMapper.fromEtudiant(etudiant);
        StageDTO stageDTO=stageMapper.fromStage(stage);
        postulationDTO.setEtudiantDTO(etudiantDTO);
        postulationDTO.setStageDTO(stageDTO);
        postulationDTO.setStatus(StatusPostulation.EN_ATTENTE);
        postulationDTO.setDate(LocalDate.now());
        Postulation postulation= postulationMapper.fromPostulationDTO(postulationDTO);
        postulation.setEtudiant(etudiant);
        postulation.setStage(stage);
        Postulation postulation1=postulationRepository.save(postulation);
        return postulationMapper.fromPostulation(postulation1);
    }

    @Override
    public List<PostulationDTO> getListPostulation() {
       List<Postulation> postulationList= postulationRepository.findAll();
       List<PostulationDTO> postulationDTOList=postulationList.stream().map(postulation -> postulationMapper.fromPostulation(postulation))
               .collect(Collectors.toList());
        return postulationDTOList;
    }

    @Override
    public void validerDemande(Long postulationId) throws PostulationNotFoundException {
        Postulation postulation=postulationRepository.findById(postulationId)
                .orElseThrow(()->new PostulationNotFoundException("Postulation Not Found"));
        postulation.setStatus(StatusPostulation.VALIDER);
        postulationRepository.save(postulation);

    }

    @Override
    public void annulerDemande(Long postulationId) throws PostulationNotFoundException {
        Postulation postulation=postulationRepository.findById(postulationId)
                .orElseThrow(()->new PostulationNotFoundException("Postulation Not Found"));
        postulation.setStatus(StatusPostulation.ANNULER);
        postulationRepository.save(postulation);


    }

    @Override
    public List<PostulationDTO> getListPostulationValider() {
        List<Postulation> postulationList=postulationRepository.findByStatus(StatusPostulation.VALIDER);
        List<PostulationDTO> postulationDTOList=postulationList.stream().map(postulation -> postulationMapper.fromPostulation(postulation))
                .collect(Collectors.toList());
        return postulationDTOList;
    }

    @Override
    public List<PostulationDTO> getListPostulerAnnuler(){
        List<Postulation> postulationList=postulationRepository.findByStatus(StatusPostulation.ANNULER);
        List<PostulationDTO> postulationDTOList=postulationList.stream().map(postulation -> postulationMapper.fromPostulation(postulation))
                .collect(Collectors.toList());

        return postulationDTOList;
    }
}
