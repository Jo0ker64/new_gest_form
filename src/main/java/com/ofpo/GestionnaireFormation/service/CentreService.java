package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Centre;
import com.ofpo.GestionnaireFormation.repository.CentreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {

    private final CentreRepository centreRepository;

    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    public List<Centre> findAll() {
        return centreRepository.findAll();
    }

    public Centre findById(Long id) {
        return centreRepository.findById(id).orElse(null);
    }

    public Centre save(Centre centre) {
        return centreRepository.save(centre);
    }

    public void deleteById(Long id) {
        centreRepository.findById(id).ifPresent(centreRepository::delete);
    }
}
