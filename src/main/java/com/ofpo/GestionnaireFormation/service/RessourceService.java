package com.ofpo.GestionnaireFormation.service;

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
        return ressourceRepository.findById(id).orElse(null);
    }

    public Ressource save(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    public void deleteById(Long id) {
        ressourceRepository.findById(id).ifPresent(ressourceRepository::delete);
    }
}
