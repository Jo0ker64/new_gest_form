package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.FormationDTO;
import com.ofpo.GestionnaireFormation.model.Formation;
import com.ofpo.GestionnaireFormation.repository.FormationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    private final FormationRepository formationRepository;

    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public List<Formation> findAll() {
        return formationRepository.findAll();
    }

    public Formation findById(Long id) {
        return formationRepository.findById(id).orElseThrow(() -> new RuntimeException("Formation non trouvée"));
    }

    public Formation save(Formation formation) {
        return formationRepository.save(formation);
    }

    public void deleteById(Long id) {
        formationRepository.deleteById(id);
    }

    public void disable(Long id) {
        Formation f = findById(id);
        f.setStatut(false);
        formationRepository.save(f);
    }

    public Formation updateFromDTO(Long id, FormationDTO dto) {
        Formation f = findById(id);
        f.setLibelle(dto.getLibelle());
        f.setNumeroOffre(dto.getNumeroOffre());
        f.setStatut(dto.isStatut());
        return formationRepository.save(f);
    }

    public FormationDTO mapToDTO(Formation f) {
        return new FormationDTO(f.getNumeroOffre(), f.getLibelle(), f.getStatut());
    }
}