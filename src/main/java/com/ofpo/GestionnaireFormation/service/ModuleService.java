package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.ModuleDTO;
import com.ofpo.GestionnaireFormation.mapper.ModuleMapper;
import com.ofpo.GestionnaireFormation.model.Module;
import com.ofpo.GestionnaireFormation.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<ModuleDTO> getAllModules() {
        return moduleRepository.findAll()
                .stream()
                .map(ModuleMapper::toDTO)
                .toList();
    }

    public Optional<ModuleDTO> getModuleById(Long id) {
        return moduleRepository.findById(id).map(ModuleMapper::toDTO);
    }

    public ModuleDTO createModule(ModuleDTO dto) {
        Module module = ModuleMapper.toEntity(dto);
        return ModuleMapper.toDTO(moduleRepository.save(module));
    }

    public ModuleDTO updateModule(Long id, ModuleDTO dto) {
        Optional<Module> opt = moduleRepository.findById(id);
        if (opt.isEmpty()) return null;
        Module module = opt.get();
        module.setLibelle(dto.getLibelle());
        return ModuleMapper.toDTO(moduleRepository.save(module));
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
