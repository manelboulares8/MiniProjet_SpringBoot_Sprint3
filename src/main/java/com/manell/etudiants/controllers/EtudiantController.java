package com.manell.etudiants.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import com.manell.etudiants.entities.Etudiant;
import com.manell.etudiants.entities.Institut;
import com.manell.etudiants.service.EtudiantService;

import jakarta.validation.Valid;

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
    public String showCreate(ModelMap modelMap) {
    	List<Institut> insts =etudiantService.getAllInstituts();
    	modelMap.addAttribute("etudiant", new Etudiant());
    	modelMap.addAttribute("mode", "new");
    	modelMap.addAttribute("Instituts",insts);

    	return "formEtudiant";    }

   /* @RequestMapping("/saveEtudiant")
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
*/
    //hedhi mtaaa mr !!!!!!!!!!!!!!!!!!!!!!!!!!!!
 /*   @RequestMapping("/saveEtudiant")
    public String saveEtudiant(@Valid Etudiant etudiant,BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) return "formEtudiant";

    	etudiantService.saveEtudiant(etudiant);
    	//return "formEtudiant";
    	return ("redirect:/listeEtudiants");
    }*/
    @RequestMapping("/saveEtudiant")
    public String saveEtudiant(
            @Valid Etudiant etudiant,
            BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size,
            ModelMap modelMap) {

        boolean isNew = (etudiant.getIdEtudiant() == null);

        if (bindingResult.hasErrors()) {
            List<Institut> insts = etudiantService.getAllInstituts();
            modelMap.addAttribute("instituts", insts);
            modelMap.addAttribute("mode", isNew ? "new" : "edit");
            return "formEtudiant";
        }

        etudiantService.saveEtudiant(etudiant);

        int currentPage;
        if (isNew) {
            Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
            currentPage = etuds.getTotalPages() - 1;
        } else {
            currentPage = page;
        }

        return "redirect:/listeEtudiants?page=" + currentPage + "&size=" + size;
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
    public String editerEtudiant(@RequestParam("id") Long id, ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
    	List<Institut> insts =etudiantService.getAllInstituts();

        Etudiant e = etudiantService.getEtudiant(id);
        modelMap.addAttribute("etudiant", e);
        modelMap.addAttribute("mode", "edit");
    	modelMap.addAttribute("instituts",insts);
    	modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		
    	return "formEtudiant";    

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
    @GetMapping(value = "/")
    public String welcome() {
     return "index";
    }
}

