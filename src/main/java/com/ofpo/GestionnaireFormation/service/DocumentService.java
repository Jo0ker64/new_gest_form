package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.DocumentDTO;
import com.ofpo.GestionnaireFormation.mapper.DocumentMapper;
import com.ofpo.GestionnaireFormation.model.Document;
import com.ofpo.GestionnaireFormation.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<DocumentDTO> getAllDocuments() {
        return documentRepository.findAll()
                .stream()
                .map(DocumentMapper::toDTO)
                .toList();
    }

    public Optional<DocumentDTO> getDocumentById(Long id) {
        return documentRepository.findById(id).map(DocumentMapper::toDTO);
    }

    public DocumentDTO createDocument(DocumentDTO dto) {
        Document doc = DocumentMapper.toEntity(dto);
        return DocumentMapper.toDTO(documentRepository.save(doc));
    }

    public DocumentDTO updateDocument(Long id, DocumentDTO dto) {
        Optional<Document> opt = documentRepository.findById(id);
        if (opt.isEmpty()) return null;
        Document doc = opt.get();
        doc.setLibelle(dto.getLibelle());
        doc.setDateCreation(dto.getDateCreation());
        return DocumentMapper.toDTO(documentRepository.save(doc));
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
