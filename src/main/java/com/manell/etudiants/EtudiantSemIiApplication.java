package com.manell.etudiants;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manell.etudiants.entities.Etudiant;
import com.manell.etudiants.service.EtudiantService;

@SpringBootApplication
public class EtudiantSemIiApplication implements CommandLineRunner{
	@Autowired
	EtudiantService etudiantService;
	public static void main(String[] args) {
		SpringApplication.run(EtudiantSemIiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*etudiantService.saveEtudiant(new Etudiant("Jemai","Ghofrane",15.43,new Date()));
		etudiantService.saveEtudiant(new Etudiant("Kerkeni ","Fatma",14.43,new Date()));
		etudiantService.saveEtudiant(new Etudiant("Makhlouf","Sarrah",16.43,new Date()));
		etudiantService.saveEtudiant(new Etudiant("Guelbi","Farah",15.1,new Date()));
*/
	}

}
