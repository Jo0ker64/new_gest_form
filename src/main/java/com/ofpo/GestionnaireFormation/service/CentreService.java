package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.CentreDTO;
import com.ofpo.GestionnaireFormation.mapper.CentreMapper;
import com.ofpo.GestionnaireFormation.model.Centre;
import com.ofpo.GestionnaireFormation.repository.CentreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentreService {

    private final CentreRepository centreRepository;

    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    public List<CentreDTO> getAllCentres() {
        return centreRepository.findAll()
                .stream()
                .map(CentreMapper::toDTO)
                .toList();
    }

    public Optional<CentreDTO> getCentreById(Long id) {
        return centreRepository.findById(id).map(CentreMapper::toDTO);
    }

    public CentreDTO createCentre(CentreDTO dto) {
        Centre centre = CentreMapper.toEntity(dto);
        return CentreMapper.toDTO(centreRepository.save(centre));
    }

    public CentreDTO updateCentre(Long id, CentreDTO dto) {
        Optional<Centre> opt = centreRepository.findById(id);
        if (opt.isEmpty()) return null;
        Centre centre = opt.get();
        centre.setNom(dto.getNom());
        centre.setAdressePostal(dto.getAdressePostal());
        centre.setCodePostal(dto.getCodePostal());
        centre.setVille(dto.getVille());
        centre.setTelephone(dto.getTelephone());
        return CentreMapper.toDTO(centreRepository.save(centre));
    }

    public void deleteCentre(Long id) {
        centreRepository.deleteById(id);
    }
}
