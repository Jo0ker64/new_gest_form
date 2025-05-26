package com.ofpo.GestionnaireFormation.mapper;

import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurDTO;
import com.ofpo.GestionnaireFormation.model.Utilisateur;

public class UtilisateurMapper {
    public static UtilisateurDTO toDTO(Utilisateur utilisateur) {
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setMatricule(utilisateur.getMatricule());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setAdresseMail(utilisateur.getAdresseMail());
        return dto;
    }

    public static Utilisateur toEntity(UtilisateurDTO dto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMatricule(dto.getMatricule());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setAdresseMail(dto.getAdresseMail());
        return utilisateur;
    }
}
