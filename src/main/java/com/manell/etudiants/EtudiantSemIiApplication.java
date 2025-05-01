package com.manell.etudiants;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.manell.etudiants.entities.*;
import com.manell.etudiants.service.EtudiantService;
import com.manell.etudiants.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EtudiantSemIiApplication implements CommandLineRunner{
	@Autowired
	EtudiantService etudiantService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;
	@Autowired 
	private RepositoryRestConfiguration repositoryRestConfiguration;
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
		
		/*repositoryRestConfiguration.exposeIdsFor(Etudiant.class); 
		System.out.println("Password Encoded BCRYPT :******************** ");
		 System.out.println(passwordEncoder.encode("123"));*/
		
	}
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"nadhem","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("nadhem", "USER");
	userService.addRoleToUser("nadhem", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}*/ 
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
}
