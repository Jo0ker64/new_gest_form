package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.RessourceDTO;
import com.ofpo.GestionnaireFormation.model.Ressource;
import com.ofpo.GestionnaireFormation.repository.RessourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceService {

    private final RessourceRepository ressourceRepository;

    public RessourceService(RessourceRepository ressourceRepository) {
        this.ressourceRepository = ressourceRepository;
    }

    public List<Ressource> findAll() {
        return ressourceRepository.findAll();
    }

    public Ressource findById(Long id) {
        return ressourceRepository.findById(id).orElseThrow(() -> new RuntimeException("Ressource non trouvée"));
    }

    public Ressource save(Ressource r) {
        return ressourceRepository.save(r);
    }

    public void deleteById(Long id) {
        ressourceRepository.deleteById(id);
    }

    public Ressource updateFromDTO(Long id, RessourceDTO dto) {
        Ressource r = findById(id);
        r.setLibelle(dto.getLibelle());
        return ressourceRepository.save(r);
    }

    public RessourceDTO mapToDTO(Ressource r) {
        return new RessourceDTO(r.getLibelle());
    }
}