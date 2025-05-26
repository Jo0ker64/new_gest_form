package com.ofpo.GestionnaireFormation.mapper;

import com.ofpo.GestionnaireFormation.DTO.DocumentDTO;
import com.ofpo.GestionnaireFormation.model.Document;

public class DocumentMapper {

    public static DocumentDTO toDTO(Document document) {
        DocumentDTO dto = new DocumentDTO();
        dto.setId(document.getId());
        dto.setLibelle(document.getLibelle());
        dto.setDateCreation(document.getDateCreation());
        return dto;
    }

    public static Document toEntity(DocumentDTO dto) {
        Document document = new Document();
        document.setId(dto.getId());
        document.setLibelle(dto.getLibelle());
        document.setDateCreation(dto.getDateCreation());
        return document;
    }
}

