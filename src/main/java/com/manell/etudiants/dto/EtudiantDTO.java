package com.manell.etudiants.dto;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.manell.etudiants.entities.Institut;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudiantDTO {
		private Long idEtudiant;
		private String nomEtudiant;
		private String prenomEtudiant;
		private Double moyEtudiant;
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date dateInscription;
		private Institut institut;
		//private String nomInstitut;
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
		public Institut getInstitut() {
			return institut;
		}
		public void setInstitut(Institut institut) {
			this.institut = institut;
		}
		/*public String getNomInstitut() {
			return nomInstitut;
		}
		public void setNomInstitut(String nomInstitut) {
			this.nomInstitut = nomInstitut;
		}
		*/
		
		
}
