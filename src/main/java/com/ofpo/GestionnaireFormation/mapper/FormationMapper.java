package com.ofpo.GestionnaireFormation.mapper;

import com.ofpo.GestionnaireFormation.DTO.DocumentDTO;
import com.ofpo.GestionnaireFormation.DTO.RessourceDTO;
import com.ofpo.GestionnaireFormation.DTO.formation.FormationDTO;
import com.ofpo.GestionnaireFormation.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class FormationMapper {

    public static FormationDTO toDTO(Formation formation) {
        FormationDTO dto = new FormationDTO();
        dto.setLibelle(formation.getLibelle());
        dto.setNumeroOffre(formation.getNumeroOffre());
        dto.setDateDebut(formation.getDateDebut());
        dto.setDateFin(formation.getDateFin());
        dto.setDateDebutPe(formation.getDateDebutPe());
        dto.setDateFinPe(formation.getDateFinPe());
        dto.setStatut(formation.getStatut());

        dto.setUtilisateurs(
                formation.getUtilisateurs().stream()
                        .map(UtilisateurMapper::toDTO)
                        .collect(Collectors.toList())
        );

        dto.setCentres(
                formation.getCentres().stream()
                        .map(CentreMapper::toDTO)
                        .collect(Collectors.toList())
        );

        dto.setModules(
                formation.getModules().stream()
                        .map(ModuleMapper::toDTO)
                        .collect(Collectors.toList())
        );

        dto.setDocuments(
                formation.getFormationDocuments().stream()
                        .map(fd -> DocumentMapper.toDTO(fd.getDocument()))
                        .collect(Collectors.toList())
        );

        dto.setRessources(
                formation.getFormationRessources().stream()
                        .map(fr -> RessourceMapper.toDTO(fr.getRessource()))
                        .collect(Collectors.toList())
        );

        return dto;
    }

    public static Formation toEntity(FormationDTO dto) {
        Formation formation = new Formation();
        formation.setLibelle(dto.getLibelle());
        formation.setNumeroOffre(dto.getNumeroOffre());
        formation.setDateDebut(dto.getDateDebut());
        formation.setDateFin(dto.getDateFin());
        formation.setDateDebutPe(dto.getDateDebutPe());
        formation.setDateFinPe(dto.getDateFinPe());
        formation.setStatut(dto.getStatut());

        formation.setUtilisateurs(
                dto.getUtilisateurs().stream()
                        .map(UtilisateurMapper::toEntity)
                        .collect(Collectors.toList())
        );

        formation.setCentres(
                dto.getCentres().stream()
                        .map(CentreMapper::toEntity)
                        .collect(Collectors.toList())
        );

        formation.setModules(
                dto.getModules().stream()
                        .map(ModuleMapper::toEntity)
                        .collect(Collectors.toList())
        );

        formation.setFormationDocuments(
                dto.getDocuments().stream()
                        .map(documentDTO -> {
                            FormationDocument fd = new FormationDocument();
                            Document doc = DocumentMapper.toEntity(documentDTO);
                            fd.setDocument(doc);
                            fd.setFormation(formation);
                            fd.setId(new FormationDocumentKey());
                            return fd;
                        }).collect(Collectors.toList())
        );

        formation.setFormationRessources(
                dto.getRessources().stream()
                        .map(ressourceDTO -> {
                            FormationRessource fr = new FormationRessource();
                            Ressource res = RessourceMapper.toEntity(ressourceDTO);
                            fr.setRessource(res);
                            fr.setFormation(formation);
                            fr.setId(new FormationRessourceKey(formation.getId(), res.getId()));
                            return fr;
                        }).collect(Collectors.toList())
        );

        return formation;
    }

    public static List<FormationRessource> mapRessources(Formation formation, List<RessourceDTO> ressources) {
        return ressources.stream()
                .map(ressourceDTO -> {
                    FormationRessource fr = new FormationRessource();
                    Ressource res = RessourceMapper.toEntity(ressourceDTO);
                    fr.setRessource(res);
                    fr.setFormation(formation);
                    fr.setId(new FormationRessourceKey(formation.getId(), res.getId()));
                    return fr;
                }).collect(Collectors.toList());
    }

    public static List<FormationDocument> mapDocuments(Formation formation, List<DocumentDTO> documents) {
        return documents.stream()
                .map(documentDTO -> {
                    FormationDocument fd = new FormationDocument();
                    Document doc = DocumentMapper.toEntity(documentDTO);
                    fd.setDocument(doc);
                    fd.setFormation(formation);
                    fd.setId(new FormationDocumentKey());
                    return fd;
                }).collect(Collectors.toList());
    }
}
