package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Module;
import com.ofpo.GestionnaireFormation.service.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/")
    public List<Module> getAll() {
        return moduleService.findAll();
    }

    @GetMapping("/{id}")
    public Module getById(@PathVariable Long id) {
        return moduleService.findById(id);
    }

    @PostMapping("/create")
    public Module create(@RequestBody Module module) {
        return moduleService.save(module);
    }

    @PutMapping("/update/{id}")
    public Module update(@PathVariable Long id, @RequestBody Module module) {
        module.setId(id);
        return moduleService.save(module);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        moduleService.deleteById(id);
    }
}
