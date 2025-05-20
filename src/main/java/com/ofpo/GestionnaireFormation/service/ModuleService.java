package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.ModuleDTO;
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
        return moduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Module non trouvé"));
    }

    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    public Module updateFromDTO(Long id, ModuleDTO dto) {
        Module m = findById(id);
        m.setLibelle(dto.getLibelle());
        return moduleRepository.save(m);
    }

    public void deleteById(Long id) {
        moduleRepository.deleteById(id);
    }

    public ModuleDTO mapToDTO(Module m) {
        return new ModuleDTO(m.getLibelle());
    }
}