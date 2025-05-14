package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Salle;
import com.ofpo.GestionnaireFormation.repository.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService {

    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    public Salle findById(Long id) {
        return salleRepository.findById(id).orElse(null);
    }

    public Salle save(Salle salle) {
        return salleRepository.save(salle);
    }

    public void deleteById(Long id) {
        salleRepository.findById(id).ifPresent(salleRepository::delete);
    }
}
