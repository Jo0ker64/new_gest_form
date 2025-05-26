package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.formation.FormationDTO;
import com.ofpo.GestionnaireFormation.mapper.FormationMapper;
import com.ofpo.GestionnaireFormation.model.Formation;
import com.ofpo.GestionnaireFormation.model.FormationDocument;
import com.ofpo.GestionnaireFormation.model.FormationRessource;
import com.ofpo.GestionnaireFormation.repository.FormationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {

    private final FormationRepository formationRepository;

    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public List<FormationDTO> getAllFormations() {
        return formationRepository.findAll()
                .stream()
                .map(FormationMapper::toDTO)
                .toList();
    }

    public Optional<FormationDTO> getFormationById(Long id) {
        return formationRepository.findById(id).map(FormationMapper::toDTO);
    }

    public FormationDTO createFormation(FormationDTO dto) {
        Formation formation = FormationMapper.toEntity(dto);

        // Gestion des jointures manuelles : Ressources & Documents
        List<FormationRessource> ressources = FormationMapper.mapRessources(formation, dto.getRessources());
        formation.setFormationRessources(ressources);

        List<FormationDocument> documents = FormationMapper.mapDocuments(formation, dto.getDocuments());
        formation.setFormationDocuments(documents);

        formationRepository.save(formation);
        return FormationMapper.toDTO(formation);
    }

    public FormationDTO updateFormation(Long id, FormationDTO dto) {
        Optional<Formation> optFormation = formationRepository.findById(id);
        if (optFormation.isEmpty()) return null;

        Formation formation = optFormation.get();
        formation.setLibelle(dto.getLibelle());
        formation.setNumeroOffre(dto.getNumeroOffre());
        formation.setDateDebut(dto.getDateDebut());
        formation.setDateFin(dto.getDateFin());
        formation.setDateDebutPe(dto.getDateDebutPe());
        formation.setDateFinPe(dto.getDateFinPe());
        formation.setStatut(dto.getStatut());

        List<FormationRessource> ressources = FormationMapper.mapRessources(formation, dto.getRessources());
        formation.setFormationRessources(ressources);

        List<FormationDocument> documents = FormationMapper.mapDocuments(formation, dto.getDocuments());
        formation.setFormationDocuments(documents);

        formationRepository.save(formation);
        return FormationMapper.toDTO(formation);
    }

    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }
}

