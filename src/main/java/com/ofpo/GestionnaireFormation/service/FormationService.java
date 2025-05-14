package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Formation;
import com.ofpo.GestionnaireFormation.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    private final FormationRepository formationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ModuleRepository moduleRepository;
    private final CentreRepository centreRepository;
    private final DocumentRepository documentRepository;
    private final RessourceRepository ressourceRepository;

    public FormationService(FormationRepository formationRepository,
                            ModuleRepository moduleRepository,
                            CentreRepository centreRepository,
                            DocumentRepository documentRepository,
                            RessourceRepository ressourceRepository,
                            UtilisateurRepository utilisateurRepository) {
        this.formationRepository = formationRepository;
        this.moduleRepository = moduleRepository;
        this.centreRepository = centreRepository;
        this.documentRepository = documentRepository;
        this.ressourceRepository = ressourceRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    // Retourne toutes les formations
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }

    // Retourne une formation par id
    public Formation findById(Long id) {
        return formationRepository.findById(id).orElse(null);
    }

    // Crée ou met à jour une formation
    public Formation save(Formation formation) {
        return formationRepository.save(formation);
    }

    // Supprime une formation
    public void deleteById(Long id) {
        formationRepository.findById(id).ifPresent(formationRepository::delete);
    }

    // Modifie le statut actif/inactif
    public void disable(Long id) {
        formationRepository.findById(id).ifPresent(formation -> {
            formation.setStatut(false);
            formationRepository.save(formation);
        });
    }
}
