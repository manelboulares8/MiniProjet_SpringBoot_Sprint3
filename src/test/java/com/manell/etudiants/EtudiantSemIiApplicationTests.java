package com.manell.etudiants;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.manell.etudiants.entities.Etudiant;
import com.manell.etudiants.repos.EtudiantRepository;
import com.manell.etudiants.service.EtudiantService;

@SpringBootTest
class EtudiantSemIiApplicationTests {
@Autowired
private EtudiantRepository etudiantRepository;
@Autowired
private EtudiantService etudiantService;
	@Test
	void contextLoads() {
	}
	
	//@Test
	public void testCreateEtudiant() {
		Etudiant etu =new Etudiant("boulares","feriel",18.1,new Date());
		etudiantRepository.save(etu);
	}
	@Test
    public void testFindEtudiant() {
        Etudiant e = etudiantRepository.findById(2L).get();
        System.out.println(e);
    }

    @Test
    public void testUpdateEtudiant() {
        Etudiant e = etudiantRepository.findById(3L).get();
        e.setMoyEtudiant(15.0);
        etudiantRepository.save(e);
    }

    @Test
    public void testDeleteEtudiant() {
        etudiantRepository.deleteById(4L);
    }

    @Test
    public void testListerTousEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }
    }
    
    @Test
    public void testFindByEtudiantContains()
    {
    Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(0,2);
    System.out.println(etuds.getSize());
    System.out.println(etuds.getTotalElements());
    System.out.println(etuds.getTotalPages());
    etuds.getContent().forEach(p -> {System.out.println(p.toString());
     });
    /*ou bien
    for (Etudiant p : etuds)
    {
    System.out.println(p);
    } */
    }
}
