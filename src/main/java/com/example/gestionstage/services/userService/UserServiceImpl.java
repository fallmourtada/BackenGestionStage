package com.example.gestionstage.services.userService;

import com.example.gestionstage.Exception.UniversiteNotFoundException;
import com.example.gestionstage.dto.AddEtudiantDTO;
import com.example.gestionstage.dto.EtudiantDTO;
import com.example.gestionstage.dto.TuteurDTO;
import com.example.gestionstage.dto.UniversiteDTO;
import com.example.gestionstage.entites.Etudiant;
import com.example.gestionstage.entites.Tuteur;
import com.example.gestionstage.entites.Universite;
import com.example.gestionstage.entites.User;
import com.example.gestionstage.mapper.EtudiantMapper;
import com.example.gestionstage.mapper.TuteurMapper;
import com.example.gestionstage.mapper.UniversiteMapper;
import com.example.gestionstage.repositories.UniversiteRepository;
import com.example.gestionstage.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private EtudiantMapper etudiantMapper;
    private TuteurMapper tuteurMapper;
    private UniversiteRepository universiteRepository;
    private UniversiteMapper universiteMapper;
    private JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    @Override
    public EtudiantDTO ajouterEtudiant(AddEtudiantDTO addEtudiantDTO) throws UniversiteNotFoundException {
        // Vérification de l'université
        Long universiteId = addEtudiantDTO.getUniversiteId();
        Universite universite = universiteRepository.findById(universiteId)
                .orElseThrow(() -> new UniversiteNotFoundException("Universite Not Found"));
        UniversiteDTO universiteDTO = universiteMapper.fromUniversite(universite);

        // Mapper les données d'étudiant
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        etudiantDTO.setCodePermanent(addEtudiantDTO.getCodePermanent());
        etudiantDTO.setNom(addEtudiantDTO.getNom());
        etudiantDTO.setPrenom(addEtudiantDTO.getPrenom());
        etudiantDTO.setNiveau(addEtudiantDTO.getNiveau());
        etudiantDTO.setEmail(addEtudiantDTO.getEmail());
        etudiantDTO.setUniversiteDTO(universiteDTO);

        // Convertir le code permanent en String
            String codePermanentString = String.valueOf(addEtudiantDTO.getCodePermanent());

        // Enregistrer l'utilisateur dans 'users' et attribuer le rôle
            String encodedPassword = passwordEncoder.encode(codePermanentString);

        jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)",
                addEtudiantDTO.getEmail(), encodedPassword, true);
        jdbcTemplate.update("INSERT INTO authorities (username, authority) VALUES (?, ?)",
                addEtudiantDTO.getEmail(), "ROLE_ETUDIANT");

        // Sauvegarder l'étudiant dans votre base métier

        Etudiant etudiant = etudiantMapper.fromEtudiantDTO(etudiantDTO);
        etudiant.setUniversite(universite);
        Etudiant savedEtudiant = userRepository.save(etudiant);

        return etudiantMapper.fromEtudiant(savedEtudiant);
    }


    @Override
    public TuteurDTO ajouterTuteur(TuteurDTO tuteurDTO) {
        // Mapper les données du tuteur
        Tuteur tuteur = tuteurMapper.fromTuteurDTO(tuteurDTO);

        // Encoder le mot de passe et insérer l'utilisateur dans 'users' et 'authorities'
        String encodedPassword = passwordEncoder.encode(tuteurDTO.getPassword());
        jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)",
                tuteurDTO.getEmail(), encodedPassword, true);
        jdbcTemplate.update("INSERT INTO authorities (username, authority) VALUES (?, ?)",
                tuteurDTO.getEmail(), "ROLE_TUTEUR");

        // Sauvegarder le tuteur dans la base métier
        Tuteur savedTuteur = userRepository.save(tuteur);

        return tuteurMapper.fromTuteur(savedTuteur);
    }

    @Override
    public List<EtudiantDTO> getAllEtudiants() {
        List<Etudiant> etudiantList=userRepository.findEtudiantsByUserType("ETUDIANT");
        List<EtudiantDTO> etudiantDTOList=etudiantList.stream().map(etudiant -> etudiantMapper.fromEtudiant(etudiant))
                .collect(Collectors.toList());
        return etudiantDTOList;
    }

    @Override
    public List<TuteurDTO> getAllTuteurs() {
        List<Tuteur> tuteurList=userRepository.findTuteursByUserType("TUTEUR");
        List<TuteurDTO> tuteurDTOList=tuteurList.stream().map(tuteur -> tuteurMapper.fromTuteur(tuteur))
                .collect(Collectors.toList());
        return tuteurDTOList;
    }

    @Override
    public void deleteEtudiant(Long etudiantId) {
        userRepository.deleteById(etudiantId);
        log.info("Etudiant Deleted Successfully");

    }

    @Override
    public void deleteTuteur(Long tuteurId) {
        userRepository.deleteById(tuteurId);
        log.info("Tuteur Deleted Successfully");

    }
}
