package com.ofpo.GestionnaireFormation.mapper;

import com.ofpo.GestionnaireFormation.DTO.RessourceDTO;
import com.ofpo.GestionnaireFormation.model.Ressource;
import com.ofpo.GestionnaireFormation.model.Type;

public class RessourceMapper {

    public static RessourceDTO toDTO(Ressource ressource) {
        RessourceDTO dto = new RessourceDTO();
        dto.setId(ressource.getId());
        dto.setLibelle(ressource.getLibelle());
        dto.setDateCreation(ressource.getDateCreation());
        dto.setDateModification(ressource.getDateModification());
        dto.setTypeId(ressource.getType() != null ? ressource.getType().getId() : null);
        dto.setTypeLibelle(ressource.getType() != null ? ressource.getType().getLibelle() : null);
        return dto;
    }

    public static Ressource toEntity(RessourceDTO dto) {
        Ressource ressource = new Ressource();
        ressource.setId(dto.getId());
        ressource.setLibelle(dto.getLibelle());
        ressource.setDateCreation(dto.getDateCreation());
        ressource.setDateModification(dto.getDateModification());

        // Optionnel : relier avec type si nécessaire
        if (dto.getTypeId() != null) {
            Type type = new Type();
            type.setId(dto.getTypeId());
            type.setLibelle(dto.getTypeLibelle());
            ressource.setType(type);
        }

        return ressource;
    }
}
