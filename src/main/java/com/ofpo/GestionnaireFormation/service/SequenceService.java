package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Sequence;
import com.ofpo.GestionnaireFormation.repository.SequenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SequenceService {

    private final SequenceRepository sequenceRepository;

    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    public List<Sequence> findAll() {
        return sequenceRepository.findAll();
    }

    public Sequence findById(Long id) {
        return sequenceRepository.findById(id).orElse(null);
    }

    public Sequence save(Sequence sequence) {
        return sequenceRepository.save(sequence);
    }

    public void deleteById(Long id) {
        sequenceRepository.findById(id).ifPresent(sequenceRepository::delete);
    }
}
