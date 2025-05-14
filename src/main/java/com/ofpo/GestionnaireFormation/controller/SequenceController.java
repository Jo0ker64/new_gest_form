package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Sequence;
import com.ofpo.GestionnaireFormation.service.SequenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sequences")
public class SequenceController {

    private final SequenceService sequenceService;

    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    @GetMapping("/")
    public List<Sequence> getAll() {
        return sequenceService.findAll();
    }

    @GetMapping("/{id}")
    public Sequence getById(@PathVariable Long id) {
        return sequenceService.findById(id);
    }

    @PostMapping("/create")
    public Sequence create(@RequestBody Sequence sequence) {
        return sequenceService.save(sequence);
    }

    @PutMapping("/update/{id}")
    public Sequence update(@PathVariable Long id, @RequestBody Sequence sequence) {
        sequence.setId(id);
        return sequenceService.save(sequence);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        sequenceService.deleteById(id);
    }
}
