package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.FormationDTO;
import com.ofpo.GestionnaireFormation.model.Formation;
import com.ofpo.GestionnaireFormation.service.FormationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/formations")
public class FormationController {

    private final FormationService formationService;

    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping("/")
    public List<FormationDTO> getAll() {
        return formationService.findAll().stream()
                .map(f -> new FormationDTO(f.getNumeroOffre(), f.getLibelle(), f.getStatut()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FormationDTO getById(@PathVariable Long id) {
        Formation f = formationService.findById(id);
        return new FormationDTO(f.getNumeroOffre(), f.getLibelle(), f.getStatut());
    }

    @PostMapping("/create")
    public FormationDTO create(@RequestBody FormationDTO dto) {
        Formation formation = new Formation();
        formation.setLibelle(dto.getLibelle());
        formation.setNumeroOffre(dto.getNumeroOffre());
        formation.setStatut(dto.isStatut());
        Formation saved = formationService.save(formation);
        return new FormationDTO(saved.getNumeroOffre(), saved.getLibelle(), saved.getStatut());
    }

    @PutMapping("/update/{id}")
    public FormationDTO update(@PathVariable Long id, @RequestBody FormationDTO dto) {
        Formation updated = formationService.updateFromDTO(id, dto);
        return new FormationDTO(updated.getNumeroOffre(), updated.getLibelle(), updated.getStatut());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        formationService.deleteById(id);
    }

    @PutMapping("/{id}/disable")
    public void disable(@PathVariable Long id) {
        formationService.disable(id);
    }
}