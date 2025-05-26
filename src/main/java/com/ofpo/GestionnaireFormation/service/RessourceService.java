package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.RessourceDTO;
import com.ofpo.GestionnaireFormation.mapper.RessourceMapper;
import com.ofpo.GestionnaireFormation.model.Ressource;
import com.ofpo.GestionnaireFormation.model.Type;
import com.ofpo.GestionnaireFormation.repository.RessourceRepository;
import com.ofpo.GestionnaireFormation.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RessourceService {

    private final RessourceRepository ressourceRepository;
    private final TypeRepository typeRepository;

    public RessourceService(RessourceRepository ressourceRepository, TypeRepository typeRepository) {
        this.ressourceRepository = ressourceRepository;
        this.typeRepository = typeRepository;
    }

    public List<RessourceDTO> getAllRessources() {
        return ressourceRepository.findAll()
                .stream()
                .map(RessourceMapper::toDTO)
                .toList();
    }

    public Optional<RessourceDTO> getRessourceById(Long id) {
        return ressourceRepository.findById(id)
                .map(RessourceMapper::toDTO);
    }

    public RessourceDTO createRessource(RessourceDTO dto) {
        Ressource res = RessourceMapper.toEntity(dto);
        if (dto.getTypeId() != null) {
            Optional<Type> typeOpt = typeRepository.findById(dto.getTypeId());
            typeOpt.ifPresent(res::setType);
        }
        return RessourceMapper.toDTO(ressourceRepository.save(res));
    }

    public RessourceDTO updateRessource(Long id, RessourceDTO dto) {
        Optional<Ressource> opt = ressourceRepository.findById(id);
        if (opt.isEmpty()) return null;
        Ressource res = opt.get();
        res.setLibelle(dto.getLibelle());
        res.setDateCreation(dto.getDateCreation());
        res.setDateModification(dto.getDateModification());
        if (dto.getTypeId() != null) {
            typeRepository.findById(dto.getTypeId()).ifPresent(res::setType);
        }
        return RessourceMapper.toDTO(ressourceRepository.save(res));
    }

    public void deleteRessource(Long id) {
        ressourceRepository.deleteById(id);
    }
}
