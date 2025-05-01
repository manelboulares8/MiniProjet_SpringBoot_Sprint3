package com.manell.etudiants.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manell.etudiants.dto.EtudiantDTO;
import com.manell.etudiants.entities.Etudiant;
import com.manell.etudiants.service.EtudiantService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class EtudiantRESTController {
	@Autowired
	EtudiantService etudiantService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EtudiantDTO> getAllEtudiants() {
		return etudiantService.getAllEtudiant();
		}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public EtudiantDTO getEtudiantById(@PathVariable("id") Long id) {
	return etudiantService.getEtudiant(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public EtudiantDTO createEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
	return etudiantService.saveEtudiant(etudiantDTO);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public EtudiantDTO updateEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
	return etudiantService.updateEtudiant(etudiantDTO);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEtudiant(@PathVariable("id") Long id)
	{
	etudiantService.deleteEtudiantById(id);
	}
	@RequestMapping(value="/etudsins/{idInstitut}",method = RequestMethod.GET)
	public List<Etudiant> getEtudiantsByInsId(@PathVariable("idCat") Long idCat) {
	return etudiantService.findByInstitutIdIns(idCat);
	}
}
