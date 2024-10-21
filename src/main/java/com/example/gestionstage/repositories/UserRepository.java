package com.example.gestionstage.repositories;

import com.example.gestionstage.entites.Etudiant;
import com.example.gestionstage.entites.Tuteur;
import com.example.gestionstage.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.role= ?1")
    List<Etudiant> findEtudiantsByUserType(String role);
    // Remplace "discriminatorValue" par "userType"

    @Query("SELECT u FROM User u WHERE u.role= ?1")
    List<Tuteur> findTuteursByUserType(String role);

    @Query("SELECT u from User u WHERE u.email= ?1")
    Etudiant findEtudiantByEmail(String email);

}
