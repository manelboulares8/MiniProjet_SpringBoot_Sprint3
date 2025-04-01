package com.manell.etudiants.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.manell.etudiants.entities.Etudiant;

public interface EtudiantService {
	Etudiant saveEtudiant(Etudiant e);
	Etudiant updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
	void deleteEtudiantById(Long id);
	Etudiant getEtudiant(Long id);
	List<Etudiant> getAllEtudiant();
	Page <Etudiant> getAllEtudiantsParPage(int page,int size);

}
