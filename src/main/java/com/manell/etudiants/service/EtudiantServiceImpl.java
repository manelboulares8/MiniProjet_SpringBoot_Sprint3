package com.manell.etudiants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.manell.etudiants.entities.Etudiant;
import com.manell.etudiants.entities.Institut;
import com.manell.etudiants.repos.EtudiantRepository;
import com.manell.etudiants.repos.InstitutRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    InstitutRepository institutRepository;
    @Override
    public Etudiant saveEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(Etudiant e) {
        etudiantRepository.delete(e);
    }

    @Override
    public void deleteEtudiantById(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiant(Long id) {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

	public Page<Etudiant> getAllEtudiantsParPage(int page,int size){
		return etudiantRepository.findAll(PageRequest.of(page,size));
	}
	@Override
    public List<Etudiant> findByNomEtudiant(String nom) {
        return etudiantRepository.findByNomEtudiant(nom);
    }

    @Override
    public List<Etudiant> findByNomEtudiantContains(String nom) {
        return etudiantRepository.findByNomEtudiantContains(nom);
    }

    @Override
    public List<Etudiant> findByNomPrenom(String nom, String prenom) {
        return etudiantRepository.findByNomPrenom(nom, prenom);
    }

    @Override
    public List<Etudiant> findByInstitut(Institut institut) {
        return etudiantRepository.findByInstitut(institut);
    }

    @Override
    public List<Etudiant> findByInstitutIdIns(Long id) {
        return etudiantRepository.findByInstitutIdInstitut(id);
    }

    @Override
    public List<Etudiant> findByOrderByNomEtudiantAsc() {
        return etudiantRepository.findByOrderByNomEtudiantAsc();
    }

    @Override
    public List<Etudiant> trierEtudiantsNomsPrenoms() {
        return etudiantRepository.trierEtudiantsNomsPrenoms();
    }
    @Override
    public List<Institut> getAllInstituts(){
    	return institutRepository.findAll();
    }
    
}