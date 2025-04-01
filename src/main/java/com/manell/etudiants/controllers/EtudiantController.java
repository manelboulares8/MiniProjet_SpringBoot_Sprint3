package com.manell.etudiants.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manell.etudiants.entities.Etudiant;
import com.manell.etudiants.service.EtudiantService;

@Controller
public class EtudiantController {
	/*@RequestMapping("/myView")
	public String myView()
	{
	return "myView";
	}*/
	@Autowired
    EtudiantService etudiantService;

    @RequestMapping("/listeEtudiants")
    public String listeEtudiants(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "2") int size) {
       Page<Etudiant> etds = etudiantService.getAllEtudiantsParPage(page,size);
        modelMap.addAttribute("etudiants", etds);
        modelMap.addAttribute("pages", new int[etds.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listeEtudiants";
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createEtudiant";
    }

    @RequestMapping("/saveEtudiant")
    public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
                               @RequestParam("date") String date,
                               ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateInscription = dateformat.parse(date);
        etudiant.setDateInscription(dateInscription);

        Etudiant savedEtudiant = etudiantService.saveEtudiant(etudiant);
        String msg = "Étudiant enregistré avec Id " + savedEtudiant.getIdEtudiant();
        modelMap.addAttribute("msg", msg);
        return "createEtudiant";
    }

    @RequestMapping("/supprimerEtudiant")
    public String supprimerEtudiant(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "2") int size){
        etudiantService.deleteEtudiantById(id);
        Page<Etudiant> etds = etudiantService.getAllEtudiantsParPage(page,size);
        modelMap.addAttribute("etudiants", etds);
        modelMap.addAttribute("pages", new int[etds.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listeEtudiants";
    }

    @RequestMapping("/modifierEtudiant")
    public String editerEtudiant(@RequestParam("id") Long id, ModelMap modelMap) {
        Etudiant e = etudiantService.getEtudiant(id);
        modelMap.addAttribute("etudiant", e);
        return "editerEtudiant";
    }

    @RequestMapping("/updateEtudiant")
    public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant, 
                                 @RequestParam("date") String date,
                                 ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateInscription = dateformat.parse(date);
        etudiant.setDateInscription(dateInscription);

        etudiantService.updateEtudiant(etudiant);
        List<Etudiant> etds = etudiantService.getAllEtudiant();
        modelMap.addAttribute("etudiants", etds);
        return "listeEtudiants";
    }
}

