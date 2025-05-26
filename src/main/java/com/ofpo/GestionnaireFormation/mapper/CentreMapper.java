package com.ofpo.GestionnaireFormation.mapper;

import com.ofpo.GestionnaireFormation.DTO.CentreDTO;
import com.ofpo.GestionnaireFormation.model.Centre;

public class CentreMapper {
    public static CentreDTO toDTO(Centre centre) {
        CentreDTO dto = new CentreDTO();
        dto.setNom(centre.getNom());
        dto.setAdressePostal(centre.getAdressePostal());
        dto.setCodePostal(centre.getCodePostal());
        dto.setVille(centre.getVille());
        dto.setTelephone(centre.getTelephone());
        return dto;
    }

    public static Centre toEntity(CentreDTO dto) {
        Centre centre = new Centre();
        centre.setNom(dto.getNom());
        centre.setAdressePostal(dto.getAdressePostal());
        centre.setCodePostal(dto.getCodePostal());
        centre.setVille(dto.getVille());
        centre.setTelephone(dto.getTelephone());
        return centre;
    }
}

