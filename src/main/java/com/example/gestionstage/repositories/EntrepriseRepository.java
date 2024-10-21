package com.example.gestionstage.repositories;

import com.example.gestionstage.entites.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
}
