package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.RessourceDTO;
import com.ofpo.GestionnaireFormation.service.RessourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ressources")
public class RessourceController {

    private final RessourceService ressourceService;

    public RessourceController(RessourceService ressourceService) {
        this.ressourceService = ressourceService;
    }

    @GetMapping("/")
    public List<RessourceDTO> getAll() {
        return ressourceService.getAllRessources();
    }

    @GetMapping("/{id}")
    public RessourceDTO getById(@PathVariable Long id) {
        return ressourceService.getRessourceById(id).orElse(null);
    }

    @PostMapping("/create")
    public RessourceDTO create(@RequestBody RessourceDTO dto) {
        return ressourceService.createRessource(dto);
    }

    @PutMapping("/update/{id}")
    public RessourceDTO update(@PathVariable Long id, @RequestBody RessourceDTO dto) {
        return ressourceService.updateRessource(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        ressourceService.deleteRessource(id);
    }
}
