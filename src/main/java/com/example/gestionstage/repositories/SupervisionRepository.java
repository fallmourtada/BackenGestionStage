package com.example.gestionstage.repositories;

import com.example.gestionstage.entites.Supervision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisionRepository extends JpaRepository<Supervision, Long> {
}
