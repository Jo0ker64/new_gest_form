package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Document;
import com.ofpo.GestionnaireFormation.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/")
    public List<Document> getAll() {
        return documentService.findAll();
    }

    @GetMapping("/{id}")
    public Document getById(@PathVariable Long id) {
        return documentService.findById(id);
    }

    @PostMapping("/create")
    public Document create(@RequestBody Document document) {
        return documentService.save(document);
    }

    @PutMapping("/update/{id}")
    public Document update(@PathVariable Long id, @RequestBody Document document) {
        document.setId(id);
        return documentService.save(document);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        documentService.deleteById(id);
    }
}
