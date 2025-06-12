package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Salle;
import com.ofpo.GestionnaireFormation.service.SalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
public class SalleController {

    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/")
    public List<Salle> getAll() {
        return salleService.findAll();
    }

    @GetMapping("/{id}")
    public Salle getById(@PathVariable Long id) {
        return salleService.findById(id);
    }

    @PostMapping("/create")
    public Salle create(@RequestBody Salle salle) {
        return salleService.save(salle);
    }

    @PutMapping("/update/{id}")
    public Salle update(@PathVariable Long id, @RequestBody Salle salle) {
        salle.setId(id);
        return salleService.save(salle);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        salleService.deleteById(id);
    }
}
