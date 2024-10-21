package com.example.gestionstage.repositories;

import com.example.gestionstage.entites.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepository extends JpaRepository<Rapport,Long> {
}
