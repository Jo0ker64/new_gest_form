package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.CentreDTO;
import com.ofpo.GestionnaireFormation.model.Centre;
import com.ofpo.GestionnaireFormation.repository.CentreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {

    private final CentreRepository centreRepository;

    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    public List<Centre> findAll() {
        return centreRepository.findAll();
    }

    public Centre findById(Long id) {
        return centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé avec l'id : " + id));
    }

    public Centre save(Centre centre) {
        return centreRepository.save(centre);
    }

    public Centre update(Long id, Centre centreDetails) {
        Centre existing = centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé avec l'id : " + id));
        existing.setNom(centreDetails.getNom());
        existing.setAdressePostale(centreDetails.getAdressePostale());
        existing.setVille(centreDetails.getVille());
        existing.setCodePostal(centreDetails.getCodePostal());
        existing.setTelephone(centreDetails.getTelephone());
        return centreRepository.save(existing);
    }

    public Centre updateFromDTO(Long id, CentreDTO dto) {
        Centre existing = centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé avec l'id : " + id));
        existing.setNom(dto.getNom());
        existing.setVille(dto.getVille());
        return centreRepository.save(existing);
    }

    public CentreDTO mapToDTO(Centre c) {
        return new CentreDTO(c.getNom(), c.getVille());
    }

    public void deleteById(Long id) {
        Centre centre = centreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre non trouvé avec l'id : " + id));
        centreRepository.delete(centre);
    }
}