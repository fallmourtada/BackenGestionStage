package com.example.gestionstage.repositories;

import com.example.gestionstage.entites.Postulation;
import com.example.gestionstage.enumeration.StatusPostulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulationRepository extends JpaRepository<Postulation, Long> {

    List<Postulation> findByStatus(StatusPostulation statusPostulation);
}
