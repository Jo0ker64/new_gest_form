package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.RoleDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurCreateDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurUpdateDTO;
import com.ofpo.GestionnaireFormation.model.Formation;
import com.ofpo.GestionnaireFormation.model.Utilisateur;
import com.ofpo.GestionnaireFormation.repository.UtilisateurRepository;
import com.ofpo.GestionnaireFormation.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurRepository utilisateurRepository, UtilisateurService utilisateurService) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/")
    public List<UtilisateurDTO> findAll() {
        // retourne la liste complète des utilisateurs (AVEC DTO)
        List<Utilisateur> utilisateurs=  this.utilisateurRepository.findAll();
        // Utilisation du DTO
        return utilisateurs.stream().map(utilisateur -> {
            // UTILISATEUR
            UtilisateurDTO dto = new UtilisateurDTO();
            dto.setMatricule(utilisateur.getMatricule());
            dto.setNom(utilisateur.getNom());
            dto.setPrenom(utilisateur.getPrenom());
            dto.setAdresseMail(utilisateur.getAdresseMail());
            // ROLES
            List<RoleDTO> roleDtos = utilisateur.getRoles().stream()
                    .map(role -> new RoleDTO(role.getLibelle()))
                    .toList();
            dto.setRoles(roleDtos);
            return dto;
        }).toList();
    }

    @GetMapping("/{matricule}")
    public List<UtilisateurDTO> findByMatricule(@PathVariable String matricule) {
        // retourner un utilisateur via un numéro de matricule
        Utilisateur utilisateur = this.utilisateurRepository.findByMatricule(matricule);
        // Utilisation du DTO
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setMatricule(utilisateur.getMatricule());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setAdresseMail(utilisateur.getAdresseMail());
        // ROLES
        List<RoleDTO> roleDtos = utilisateur.getRoles().stream()
                .map(role -> new RoleDTO(role.getLibelle()))
                .toList();
        dto.setRoles(roleDtos);
        return List.of(dto);
    }

    @PostMapping("/create")
    public UtilisateurCreateDTO add(@RequestBody UtilisateurCreateDTO dto) {
        // ajouter un utilisateur en base de données
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMatricule(dto.getMatricule());
        utilisateur.setAvatar(dto.getAvatar());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setAdresseMail(dto.getAdresseMail());
        utilisateur.setAdressePostal(dto.getAdressePostal());
        utilisateur.setCodePostal(dto.getCodePostal());
        utilisateur.setVille(dto.getVille());
        utilisateur.setMotDePasse(dto.getMotDePasse());
        utilisateur.setStatut(dto.getStatut());
        // ROLES
        List<RoleDTO> roleDtos = dto.getRoles().stream()
                .map(role -> new RoleDTO(role.getLibelle()))
                .toList();
        dto.setRoles(roleDtos);
        this.utilisateurRepository.save(utilisateur);
        return dto;
    }

    @PutMapping("/update/{matricule}")
    public UtilisateurUpdateDTO update(@PathVariable String matricule, @RequestBody UtilisateurUpdateDTO dto) {
        // modifier un utilisateur en base de données
        Utilisateur utilisateur = this.utilisateurRepository.findByMatricule(matricule);
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setAdresseMail(dto.getAdresseMail());
        utilisateur.setStatut(dto.getStatut());
        this.utilisateurRepository.save(utilisateur);
        return dto;
    }

    @DeleteMapping("/delete/{matricule}")
    public void delete(@PathVariable String matricule) {
        // supprime un utilisateur en base de données
        Utilisateur utilisateur = this.utilisateurRepository.findByMatricule(matricule);
        this.utilisateurRepository.delete(utilisateur);
    }

    //  AJOUT : Récupérer les formations d’un utilisateur
    @GetMapping("/{matricule}/formations")
    public List<Formation> getFormations(@PathVariable String matricule) {
        Utilisateur utilisateur = this.utilisateurRepository.findByMatricule(matricule);
        return utilisateur.getFormations();
    }

    // 🔄 AJOUT : Modifier les formations d’un utilisateur
    @PutMapping("/{matricule}/formations")
    public List<Formation> updateFormations(
            @PathVariable String matricule,
            @RequestBody List<Formation> nouvellesFormations
    ) {
        Utilisateur utilisateur = this.utilisateurRepository.findByMatricule(matricule);
        utilisateur.setFormations(nouvellesFormations);
        utilisateurRepository.save(utilisateur);
        return utilisateur.getFormations();
    }
}