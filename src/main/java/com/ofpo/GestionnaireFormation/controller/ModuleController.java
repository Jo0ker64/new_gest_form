package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.ModuleDTO;
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
    public List<ModuleDTO> getAll() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public ModuleDTO getById(@PathVariable Long id) {
        return moduleService.getModuleById(id).orElse(null);
    }

    @PostMapping("/create")
    public ModuleDTO create(@RequestBody ModuleDTO dto) {
        return moduleService.createModule(dto);
    }

    @PutMapping("/update/{id}")
    public ModuleDTO update(@PathVariable Long id, @RequestBody ModuleDTO dto) {
        return moduleService.updateModule(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        moduleService.deleteModule(id);
    }
}
