package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.RoleDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurCreateDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurUpdateDTO;
import com.ofpo.GestionnaireFormation.model.Formation;
import com.ofpo.GestionnaireFormation.model.Utilisateur;
import com.ofpo.GestionnaireFormation.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findByMatricule(String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

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

    public Utilisateur updateFromDTO(String matricule, UtilisateurUpdateDTO dto) {
        Utilisateur existing = utilisateurRepository.findByMatricule(matricule);
        existing.setNom(dto.getNom());
        existing.setPrenom(dto.getPrenom());
        existing.setAdresseMail(dto.getAdresseMail());
        return utilisateurRepository.save(existing);
    }

    public void deleteByMatricule(String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        utilisateurRepository.delete(user);
    }

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

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        if (!utilisateur.getMotDePasse().startsWith("$2a$")) {
            utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        }
        return utilisateurRepository.save(utilisateur);
    }
}
