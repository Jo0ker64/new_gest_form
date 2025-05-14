package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Type;
import com.ofpo.GestionnaireFormation.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    public Type findById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    public Type save(Type type) {
        return typeRepository.save(type);
    }

    public void deleteById(Long id) {
        typeRepository.findById(id).ifPresent(typeRepository::delete);
    }
}
