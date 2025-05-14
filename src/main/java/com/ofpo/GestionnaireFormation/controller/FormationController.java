package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Formation;
import com.ofpo.GestionnaireFormation.service.FormationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
public class FormationController {

    private final FormationService formationService;

    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping("/")
    public List<Formation> getAll() {
        return formationService.findAll();
    }

    @GetMapping("/{id}")
    public Formation getById(@PathVariable Long id) {
        return formationService.findById(id);
    }

    @PostMapping("/create")
    public Formation create(@RequestBody Formation formation) {
        return formationService.save(formation);
    }

    @PutMapping("/update/{id}")
    public Formation update(@PathVariable Long id, @RequestBody Formation formation) {
        formation.setId(id);
        return formationService.save(formation);
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
