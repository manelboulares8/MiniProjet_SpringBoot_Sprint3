package com.manell.etudiants.entities;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Institut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInstitut;
	private String nomInstitut;
	private String localisation;
	@JsonIgnore
	@OneToMany(mappedBy = "institut")
	private List <Etudiant> etudiants;
	public Institut(Long idInstitut, String nomInstitut, String localisation, List<Etudiant> etudiants) {
		super();
		this.idInstitut = idInstitut;
		this.nomInstitut = nomInstitut;
		this.localisation = localisation;
		this.etudiants = etudiants;
	}
	public Institut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdInstitut() {
		return idInstitut;
	}
	public void setIdInstitut(Long idInstitut) {
		this.idInstitut = idInstitut;
	}
	public String getNomInstitut() {
		return nomInstitut;
	}
	public void setNomInstitut(String nomInstitut) {
		this.nomInstitut = nomInstitut;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	@Override
	public String toString() {
		return "Institut [idInstitut=" + idInstitut + ", nomInstitut=" + nomInstitut + ", localisation=" + localisation
				+ ", etudiants=" + etudiants + "]";
	}
	

}
