package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.DocumentDTO;
import com.ofpo.GestionnaireFormation.model.Document;
import com.ofpo.GestionnaireFormation.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/")
    public List<DocumentDTO> getAll() {
        return documentService.findAll().stream()
                .map(doc -> new DocumentDTO(doc.getLibelle(), doc.getDateCreation()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DocumentDTO getById(@PathVariable Long id) {
        Document doc = documentService.findById(id);
        return new DocumentDTO(doc.getLibelle(), doc.getDateCreation());
    }

    @PostMapping("/create")
    public DocumentDTO create(@RequestBody DocumentDTO dto) {
        Document document = new Document();
        document.setLibelle(dto.getLibelle());
        document.setDateCreation(dto.getDateCreation());
        Document saved = documentService.save(document);
        return new DocumentDTO(saved.getLibelle(), saved.getDateCreation());
    }

    @PutMapping("/update/{id}")
    public DocumentDTO update(@PathVariable Long id, @RequestBody DocumentDTO dto) {
        Document updated = documentService.updateFromDTO(id, dto);
        return new DocumentDTO(updated.getLibelle(), updated.getDateCreation());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        documentService.deleteById(id);
    }
}