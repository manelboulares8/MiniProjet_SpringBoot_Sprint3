package com.manell.etudiants.repos;
import com.manell.etudiants.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface InstitutRepository extends JpaRepository<Institut, Long>{

}
