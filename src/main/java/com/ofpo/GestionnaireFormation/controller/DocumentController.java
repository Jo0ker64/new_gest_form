package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.DocumentDTO;
import com.ofpo.GestionnaireFormation.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/")
    public List<DocumentDTO> getAll() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public DocumentDTO getById(@PathVariable Long id) {
        return documentService.getDocumentById(id).orElse(null);
    }

    @PostMapping("/create")
    public DocumentDTO create(@RequestBody DocumentDTO dto) {
        return documentService.createDocument(dto);
    }

    @PutMapping("/update/{id}")
    public DocumentDTO update(@PathVariable Long id, @RequestBody DocumentDTO dto) {
        return documentService.updateDocument(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }
}
