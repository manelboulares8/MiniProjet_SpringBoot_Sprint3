package com.manell.etudiants.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.manell.etudiants.dto.EtudiantDTO;
import com.manell.etudiants.entities.Etudiant;
import com.manell.etudiants.entities.Institut;
import com.manell.etudiants.repos.EtudiantRepository;
import com.manell.etudiants.repos.InstitutRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	ModelMapper modelMapper;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    InstitutRepository institutRepository;
    @Override
    public EtudiantDTO saveEtudiant(EtudiantDTO e) {
        return convertEntityToDto( etudiantRepository.save(convertDtoToEntity(e)));
    }

    @Override
    public EtudiantDTO updateEtudiant(EtudiantDTO e) {
        return convertEntityToDto(etudiantRepository.save(convertDtoToEntity(e)));
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
    public EtudiantDTO getEtudiant(Long id) {
        return convertEntityToDto(etudiantRepository.findById(id).get());
    }

    @Override
    public List<EtudiantDTO> getAllEtudiant() {
        return etudiantRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
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
 /*   @Override
	public EtudiantDTO convertEntityToDto (Etudiant etudiant) {
    	EtudiantDTO etudiantDTO =new EtudiantDTO();
    	etudiantDTO.setIdEtudiant(etudiant.getIdEtudiant());
    	etudiantDTO.setNomEtudiant(etudiant.getNomEtudiant());
    	etudiantDTO.setPrenomEtudiant(etudiant.getPrenomEtudiant());
        etudiantDTO.setMoyEtudiant(etudiant.getMoyEtudiant());
    	etudiantDTO.setDateInscription(etudiant.getDateInscription());
    //	etudiantDTO.setInstitut(etudiant.getInstitut());
    	etudiantDTO.setNomInstitut(etudiant.getInstitut().getNomInstitut());
    	return etudiantDTO;
    	
    	/*return EtudiantDTO.builder()
    			.idEtudiant(etudiant.getIdEtudiant())
    			.nomEtudiant(etudiant.getNomEtudiant())
    			.prenomEtudiant(etudiant.getPrenomEtudiant())
    			.dateInscription(etudiant.getDateInscription())
    			.institut(etudiant.getInstitut())
    			.moyEtudiant(etudiant.getMoyEtudiant())
    			.build();
    		
	}*/
    @Override
	public EtudiantDTO convertEntityToDto (Etudiant etudiant) {
    	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    	EtudiantDTO etudiantDTO=modelMapper.map(etudiant, EtudiantDTO.class);
    	return etudiantDTO;
    }
    
   /* @Override
	public Etudiant convertDtoToEntity (EtudiantDTO etudiantDto) {
    	Etudiant etudiantDTO =new Etudiant();
    	etudiantDTO.setIdEtudiant(etudiantDto.getIdEtudiant());
    	etudiantDTO.setNomEtudiant(etudiantDto.getNomEtudiant());
    	etudiantDTO.setPrenomEtudiant(etudiantDto.getPrenomEtudiant());
        etudiantDTO.setMoyEtudiant(etudiantDto.getMoyEtudiant());
    	etudiantDTO.setDateInscription(etudiantDto.getDateInscription());
    //	etudiantDTO.setInstitut(etudiant.getInstitut());
    //	etudiantDTO.setNomInstitut(etudiantDto.getInstitut().getNomInstitut());
    	return etudiantDTO;
    }*/
    @Override
	public Etudiant convertDtoToEntity (EtudiantDTO etudiantDto) {
    	Etudiant etudiant =new Etudiant();
    	etudiant=modelMapper.map(etudiantDto, Etudiant.class);
    	return etudiant;
    }
    public Etudiant converDtoToEntityForCreate(EtudiantDTO etudiantDto) {
    	Etudiant etudiant =new Etudiant();
    	etudiant=modelMapper.map(etudiantDto, Etudiant.class);
    	etudiant.setIdEtudiant(null);
    	return etudiant;
    }
}