package com.ofpo.GestionnaireFormation.mapper;

import com.ofpo.GestionnaireFormation.DTO.ModuleDTO;
import com.ofpo.GestionnaireFormation.model.Module;

public class ModuleMapper {
    public static ModuleDTO toDTO(Module module) {
        ModuleDTO dto = new ModuleDTO();
        dto.setId(module.getId());
        dto.setLibelle(module.getLibelle());
        return dto;
    }

    public static Module toEntity(ModuleDTO dto) {
        Module module = new Module();
        module.setId(dto.getId());
        module.setLibelle(dto.getLibelle());
        return module;
    }
}

