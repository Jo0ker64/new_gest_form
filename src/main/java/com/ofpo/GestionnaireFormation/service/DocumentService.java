package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.DocumentDTO;
import com.ofpo.GestionnaireFormation.model.Document;
import com.ofpo.GestionnaireFormation.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    public Document findById(Long id) {
        return documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document non trouvé"));
    }

    public Document save(Document document) {
        return documentRepository.save(document);
    }

    public Document updateFromDTO(Long id, DocumentDTO dto) {
        Document doc = documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document non trouvé"));
        doc.setLibelle(dto.getLibelle());
        doc.setDateCreation(dto.getDateCreation());
        return documentRepository.save(doc);
    }

    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }

    public DocumentDTO mapToDTO(Document d) {
        return new DocumentDTO(d.getLibelle(), d.getDateCreation());
    }
}