package com.manell.etudiants.entities;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity

public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomEtudiant;
	@NotNull
	@Size (min = 4,max = 15)
	private String prenomEtudiant;
	@Min(value = 0)
	 @Max(value = 20)
	private Double moyEtudiant;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateInscription;
	@ManyToOne
	private Institut institut;
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant( String nomEtudiant, String prenomEtudiant, Double moyEtudiant,
			Date dateInscription) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.moyEtudiant = moyEtudiant;
		this.dateInscription = dateInscription;
	}
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}
	public Double getMoyEtudiant() {
		return moyEtudiant;
	}
	public void setMoyEtudiant(Double moyEtudiant) {
		this.moyEtudiant = moyEtudiant;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant="
				+ prenomEtudiant + ", moyEtudiant=" + moyEtudiant + ", dateInscription=" + dateInscription + "]";
	}
	public Institut getInstitut() {
		return institut;
	}
	public void setInstitut(Institut institut) {
		this.institut = institut;
	}
	public Etudiant(Long idEtudiant, String nomEtudiant, String prenomEtudiant, Double moyEtudiant,
			Date dateInscription, Institut institut) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.moyEtudiant = moyEtudiant;
		this.dateInscription = dateInscription;
		this.institut = institut;
	}
	
	
}
