package com.manell.etudiants.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.manell.etudiants.entities.Etudiant;
import com.manell.etudiants.entities.Institut;

public interface EtudiantService {
	Etudiant saveEtudiant(Etudiant e);
	Etudiant updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
	void deleteEtudiantById(Long id);
	Etudiant getEtudiant(Long id);
	List<Etudiant> getAllEtudiant();
	Page <Etudiant> getAllEtudiantsParPage(int page,int size);
	List<Etudiant> findByNomEtudiant(String nom);
	List<Etudiant> findByNomEtudiantContains(String nom);
	List<Etudiant> findByNomPrenom (String nom, String prenom);
	List<Etudiant> findByInstitut(Institut institut);
	List<Etudiant> findByInstitutIdIns(Long id);
	List<Etudiant> findByOrderByNomEtudiantAsc();
	List<Etudiant> trierEtudiantsNomsPrenoms();
	List<Institut> getAllInstituts();
}
