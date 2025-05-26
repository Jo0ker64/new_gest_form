
package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.RoleDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurUpdateDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurCreateDTO;

import com.ofpo.GestionnaireFormation.model.Formation;
import com.ofpo.GestionnaireFormation.model.Utilisateur;
import com.ofpo.GestionnaireFormation.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    // Injection du repository UtilisateurRepository
    private final UtilisateurRepository utilisateurRepository;

    // Constructeur de la classe UtilisateurService
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // Méthode pour récupérer tous les utilisateurs
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    // Méthode pour récupérer un utilisateur par son ID
    public Utilisateur findByMatricule(String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

    // Méthode pour créer un nouvel utilisateur à partir d'un DTO
    public Utilisateur saveFromDTO(UtilisateurCreateDTO dto) {
        Utilisateur u = new Utilisateur();
        u.setMatricule(dto.getMatricule());
        u.setNom(dto.getNom());
        u.setPrenom(dto.getPrenom());
        u.setAdresseMail(dto.getAdresseMail());
        u.setCodePostal(dto.getCodePostal());
        u.setVille(dto.getVille());
        return utilisateurRepository.save(u);
    }

    // Méthode pour mettre à jour un utilisateur existant à partir d'un DTO
    public Utilisateur updateFromDTO(String matricule, UtilisateurUpdateDTO dto) {
        Utilisateur existing = utilisateurRepository.findByMatricule(matricule);
        existing.setNom(dto.getNom());
        existing.setPrenom(dto.getPrenom());
        existing.setAdresseMail(dto.getAdresseMail());
        return utilisateurRepository.save(existing);
    }

    // Méthode pour supprimer un utilisateur par son matricule
    public void deleteByMatricule(String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        utilisateurRepository.delete(user);
    }

    // mapToDTO : Convertit un Utilisateur en UtilisateurDTO
    public UtilisateurDTO mapToDTO(Utilisateur u) {
        return new UtilisateurDTO(
                u.getMatricule(),
                u.getNom(),
                u.getPrenom(),
                u.getAdresseMail(),
                u.getCodePostal(),
                u.getVille(),
                u.getRoles().stream()
                        .map(role -> new RoleDTO(role.getLibelle()))
                        .toList()
        );
    }

    // MÉTHODES FORMATION AJOUTÉES CI-DESSOUS

    public Utilisateur addFormationsToUtilisateur(String matricule, List<Formation> formations) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable avec le matricule : " + matricule);
        }

        user.getFormations().addAll(formations);
        return utilisateurRepository.save(user);
    }

    public Utilisateur setFormationsToUtilisateur(String matricule, List<Formation> formations) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable avec le matricule : " + matricule);
        }

        user.setFormations(formations);
        return utilisateurRepository.save(user);
    }

    public List<Formation> getFormationsByUtilisateur(String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable avec le matricule : " + matricule);
        }

        return user.getFormations();
    }
}