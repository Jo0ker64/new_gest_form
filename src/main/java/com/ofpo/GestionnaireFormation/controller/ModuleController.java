package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.ModuleDTO;
import com.ofpo.GestionnaireFormation.model.Module;
import com.ofpo.GestionnaireFormation.service.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/")
    public List<ModuleDTO> getAll() {
        return moduleService.findAll().stream()
                .map(m -> new ModuleDTO(m.getLibelle()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ModuleDTO getById(@PathVariable Long id) {
        Module m = moduleService.findById(id);
        return new ModuleDTO(m.getLibelle());
    }

    @PostMapping("/create")
    public ModuleDTO create(@RequestBody ModuleDTO dto) {
        Module module = new Module();
        module.setLibelle(dto.getLibelle());
        Module saved = moduleService.save(module);
        return new ModuleDTO(saved.getLibelle());
    }

    @PutMapping("/update/{id}")
    public ModuleDTO update(@PathVariable Long id, @RequestBody ModuleDTO dto) {
        Module updated = moduleService.updateFromDTO(id, dto);
        return new ModuleDTO(updated.getLibelle());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        moduleService.deleteById(id);
    }
}