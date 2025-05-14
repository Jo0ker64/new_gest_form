package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Ressource;
import com.ofpo.GestionnaireFormation.service.RessourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ressources")
public class RessourceController {

    private final RessourceService ressourceService;

    public RessourceController(RessourceService ressourceService) {
        this.ressourceService = ressourceService;
    }

    @GetMapping("/")
    public List<Ressource> getAll() {
        return ressourceService.findAll();
    }

    @GetMapping("/{id}")
    public Ressource getById(@PathVariable Long id) {
        return ressourceService.findById(id);
    }

    @PostMapping("/create")
    public Ressource create(@RequestBody Ressource ressource) {
        return ressourceService.save(ressource);
    }

    @PutMapping("/update/{id}")
    public Ressource update(@PathVariable Long id, @RequestBody Ressource ressource) {
        ressource.setId(id);
        return ressourceService.save(ressource);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        ressourceService.deleteById(id);
    }
}
