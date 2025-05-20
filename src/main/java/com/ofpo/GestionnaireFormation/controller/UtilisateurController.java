package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.UtilisateurDTO;
import com.ofpo.GestionnaireFormation.model.Utilisateur;
import com.ofpo.GestionnaireFormation.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.List;

// CONTROLLER SANS LE DTO
//@RestController
//@RequestMapping("/utilisateurs")
//public class UtilisateurController {
//
//    private final UtilisateurService utilisateurService;
//
//    public UtilisateurController(UtilisateurService utilisateurService) {
//        this.utilisateurService = utilisateurService;
//    }
//
//    @GetMapping("/")
//    public List<UtilisateurDTO> findAll() {
//        return utilisateurService.findAll();
//    }
//
//    @GetMapping("/{matricule}")
//    public Utilisateur findByMatricule(@PathVariable String matricule) {
//        return utilisateurService.findByMatricule(matricule);
//    }
//
//    @GetMapping("/role/{roleId}")
//    public List<Utilisateur> findByRole(@PathVariable Long roleId) {
//        return utilisateurService.findByRoleId(roleId);
//    }
//
//    @PostMapping("/create")
//    public Utilisateur add(@RequestBody Utilisateur utilisateur) {
//        return utilisateurService.save(utilisateur);
//    }
//
//    @PutMapping("/update/{matricule}")
//    public Utilisateur update(@PathVariable String matricule, @RequestBody Utilisateur utilisateur) {
//        return utilisateurService.update(matricule, utilisateur);
//    }
//
//    @DeleteMapping("/delete/{matricule}")
//    public void delete(@PathVariable String matricule) {
//        utilisateurService.deleteByMatricule(matricule);
//    }
//
//    @PutMapping("/disable/{matricule}")
//    public void disable(@PathVariable String matricule) {
//        utilisateurService.disableByMatricule(matricule);
//    }
//}

// AVEC DTO
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private UtilisateurDTO utilisateurDTO;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/")
    public List<UtilisateurDTO> findAll() {
        return utilisateurService.findAll().stream()
                .map(utilisateurService::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{matricule}")
    public UtilisateurDTO findByMatricule(@PathVariable String matricule) {
        return utilisateurService.mapToDTO(utilisateurService.findByMatricule(matricule));
    }

    @PostMapping("/create")
    public UtilisateurDTO add(@RequestBody UtilisateurDTO dto) {
        Utilisateur saved = utilisateurService.saveFromDTO(dto);
        return utilisateurDTO;
    }

    @PutMapping("/update/{matricule}")
    public UtilisateurDTO update(@PathVariable String matricule, @RequestBody UtilisateurDTO dto) {
        Utilisateur updated = utilisateurService.updateFromDTO(matricule, dto);
        return utilisateurService.mapToDTO(updated);
    }

    @DeleteMapping("/delete/{matricule}")
    public void delete(@PathVariable String matricule) {
        utilisateurService.deleteByMatricule(matricule);
    }

    @PutMapping("/disable/{matricule}")
    public void disable(@PathVariable String matricule) {
        utilisateurService.disableByMatricule(matricule);
    }
}