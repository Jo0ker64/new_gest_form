package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Centre;
import com.ofpo.GestionnaireFormation.repository.CentreRepository;
import com.ofpo.GestionnaireFormation.repository.FormationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centres")
public class CentreController {

    private final CentreRepository centreRepository;
    private final FormationRepository formationRepository;

    public CentreController(CentreRepository centreRepository, FormationRepository formationRepository) {
        this.centreRepository = centreRepository;
        this.formationRepository = formationRepository;
    }

    // Récupère tous les centres
    @GetMapping("/")
    public List<Centre> findAll() {
        return centreRepository.findAll();
    }

    // Récupère un centre par id
    @GetMapping("/{id}")
    public Centre findById(Long id) {
        return centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé avec l'id : " + id));
    }

    // Crée un nouveau centre
    @PostMapping("/create")
    public Centre create(@RequestBody Centre centre) {
        return centreRepository.save(centre);
    }

    // Met à jour un centre existant
    @PutMapping("/update/{id}")
    public Centre update(@PathVariable Long id, @RequestBody Centre centre) {
        Centre existingCentre = centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé avec l'id : " + id));
        existingCentre.setNom(centre.getNom());
        existingCentre.setAdressePostale(centre.getAdressePostale());
        existingCentre.setTelephone(centre.getTelephone());
        return centreRepository.save(existingCentre);
    }

    // Supprime un centre
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Centre centre = centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé avec l'id : " + id));
        centreRepository.delete(centre);
    }

}