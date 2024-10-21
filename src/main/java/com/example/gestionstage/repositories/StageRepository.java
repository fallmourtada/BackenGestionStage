package com.example.gestionstage.repositories;

import com.example.gestionstage.entites.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {


}
