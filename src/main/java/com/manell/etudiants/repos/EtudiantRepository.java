package com.manell.etudiants.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.manell.etudiants.entities.*;
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

}
