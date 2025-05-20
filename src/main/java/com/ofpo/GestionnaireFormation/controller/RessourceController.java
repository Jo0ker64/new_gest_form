package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.RessourceDTO;
import com.ofpo.GestionnaireFormation.model.Ressource;
import com.ofpo.GestionnaireFormation.service.RessourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ressources")
public class RessourceController {

    private final RessourceService ressourceService;

    public RessourceController(RessourceService ressourceService) {
        this.ressourceService = ressourceService;
    }

    @GetMapping("/")
    public List<RessourceDTO> getAll() {
        return ressourceService.findAll().stream()
                .map(r -> new RessourceDTO(r.getLibelle()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RessourceDTO getById(@PathVariable Long id) {
        Ressource r = ressourceService.findById(id);
        return new RessourceDTO(r.getLibelle());
    }

    @PostMapping("/create")
    public RessourceDTO create(@RequestBody RessourceDTO dto) {
        Ressource ressource = new Ressource();
        ressource.setLibelle(dto.getLibelle());
        Ressource saved = ressourceService.save(ressource);
        return new RessourceDTO(saved.getLibelle());
    }

    @PutMapping("/update/{id}")
    public RessourceDTO update(@PathVariable Long id, @RequestBody RessourceDTO dto) {
        Ressource updated = ressourceService.updateFromDTO(id, dto);
        return new RessourceDTO(updated.getLibelle());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        ressourceService.deleteById(id);
    }
}