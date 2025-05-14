package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Module;
import com.ofpo.GestionnaireFormation.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    public Module findById(Long id) {
        return moduleRepository.findById(id).orElse(null);
    }

    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    public void deleteById(Long id) {
        moduleRepository.findById(id).ifPresent(moduleRepository::delete);
    }
}
