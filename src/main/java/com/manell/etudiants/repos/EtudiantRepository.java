package com.manell.etudiants.repos;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.manell.etudiants.entities.*;
@RepositoryRestResource(path = "rest")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
 List <Etudiant> findByNomEtudiant(String nom);
 List <Etudiant> findByNomEtudiantContains(String nom);
 @Query("select e from Etudiant e where e.nomEtudiant like %?1 and e.prenomEtudiant > ?2")
 List<Etudiant> findByNomPrenom(String nom, String prenom);
 // On peut nommer les paramètres avec l’annotation @Param
 /*@Query("select e from Etudiant e where e.nomEtudiant like %?1 and e.prenomEtudiant > ?2")
 List<Etudiant> findByNomPrenom(@Param("nom") String nom, @Param("prenom") String prenom);

*/
 @Query("select e from Etudiant e where e.institut = ?1")
 List<Etudiant> findByInstitut (Institut institut);
 List<Etudiant> findByInstitutIdInstitut(Long id);
 List<Etudiant> findByOrderByNomEtudiantAsc();
 @Query("select e from Etudiant e order by e.nomEtudiant ASC, e.prenomEtudiant DESC")
 List<Etudiant> trierEtudiantsNomsPrenoms();
}
