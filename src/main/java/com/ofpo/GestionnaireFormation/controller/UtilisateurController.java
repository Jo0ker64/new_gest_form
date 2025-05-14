package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Role;
import com.ofpo.GestionnaireFormation.model.Utilisateur;
import com.ofpo.GestionnaireFormation.repository.FormationRepository;
import com.ofpo.GestionnaireFormation.repository.RoleRepository;
import com.ofpo.GestionnaireFormation.repository.UtilisateurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final FormationRepository formationRepository;

    public UtilisateurController(   UtilisateurRepository utilisateurRepository,
                                    RoleRepository roleRepository,
                                    FormationRepository formationRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.formationRepository = formationRepository;
    }

    // Récupère tous les utilisateurs
    @GetMapping("/")
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    // Récupère un utilisateur par matricule
    @GetMapping("/{matricule}")
    public Utilisateur findByMatricule(@PathVariable String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

    // Crée un nouvel utilisateur
    @PostMapping("/create")
    public void add(@RequestBody Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    // Met à jour un utilisateur existant
    @PutMapping("/update/{matricule}")
    public void update(@PathVariable String matricule, @RequestBody Utilisateur utilisateur) {
        Utilisateur existingUser = utilisateurRepository.findByMatricule(matricule);
        if (existingUser != null) {
            existingUser.setMatricule(utilisateur.getMatricule());
            existingUser.setAvatar(utilisateur.getAvatar());
            existingUser.setNom(utilisateur.getNom());
            existingUser.setPrenom(utilisateur.getPrenom());
            existingUser.setAdresseMail(utilisateur.getAdresseMail());
            existingUser.setAdressePostal(utilisateur.getAdressePostal());
            existingUser.setCodePostal(utilisateur.getCodePostal());
            existingUser.setVille(utilisateur.getVille());
            existingUser.setMotDePasse(utilisateur.getMotDePasse());
            existingUser.setStatut(utilisateur.getStatut());
            existingUser.setRoles(utilisateur.getRoles());
            existingUser.setFormations(utilisateur.getFormations());
            utilisateurRepository.save(existingUser);
        }
    }

    // Supprime un utilisateur
    @DeleteMapping("/delete/{matricule}")
    public void delete(@PathVariable String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        if (user != null) {
            utilisateurRepository.delete(user);
        }
    }

    // Désactive un utilisateur
    @PutMapping("/disable/{matricule}")
    public void disable(@PathVariable String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        if (user != null) {
            user.setStatut(false);
            utilisateurRepository.save(user);
        }
    }

    // Affecte une liste de rôles à un utilisateur
    @PutMapping("/{matricule}/roles")
    public void assignRolesToUtilisateur(@PathVariable String matricule, @RequestBody List<Long> roleIds) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            List<Role> roles = roleRepository.findAllById(roleIds);
            utilisateur.setRoles(roles);
            utilisateurRepository.save(utilisateur);
        }
    }
}
