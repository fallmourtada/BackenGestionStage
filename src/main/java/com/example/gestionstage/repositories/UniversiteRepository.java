package com.example.gestionstage.repositories;

import com.example.gestionstage.entites.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}