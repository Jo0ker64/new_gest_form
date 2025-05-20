
package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.UtilisateurDTO;
import com.ofpo.GestionnaireFormation.model.Utilisateur;
import com.ofpo.GestionnaireFormation.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//  SERVICE SANS DTO
//@Service
//public class UtilisateurService {
//
//    private final UtilisateurRepository utilisateurRepository;
//
//    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
//        this.utilisateurRepository = utilisateurRepository;
//    }
//
//    public List<UtilisateurDTO> findAll() {
//        return utilisateurRepository.findAll();
//    }
//
//    public Utilisateur findById(Long id) {
//        return utilisateurRepository.findById(id).orElse(null);
//    }
//
//    public Utilisateur findByMatricule(String matricule) {
//        return utilisateurRepository.findByMatricule(matricule);
//    }
//
//    public List<Utilisateur> findByRoleId(Long roleId) {
//        return utilisateurRepository.findByRolesId(roleId);
//    }
//
//    public Utilisateur save(Utilisateur utilisateur) {
//        return utilisateurRepository.save(utilisateur);
//    }
//
//    public Utilisateur update(String matricule, Utilisateur newUser) {
//        Utilisateur existing = utilisateurRepository.findByMatricule(matricule);
//        if (existing != null) {
//            existing.setMatricule(newUser.getMatricule());
//            existing.setAvatar(newUser.getAvatar());
//            existing.setNom(newUser.getNom());
//            existing.setPrenom(newUser.getPrenom());
//            existing.setAdresseMail(newUser.getAdresseMail());
//            existing.setAdressePostal(newUser.getAdressePostal());
//            existing.setCodePostal(newUser.getCodePostal());
//            existing.setVille(newUser.getVille());
//            existing.setMotDePasse(newUser.getMotDePasse());
//            existing.setStatut(newUser.getStatut());
//            existing.setRoles(newUser.getRoles());
//            existing.setFormations(newUser.getFormations());
//            return utilisateurRepository.save(existing);
//        }
//        throw new RuntimeException("Utilisateur introuvable avec le matricule : " + matricule);
//    }
//
//    public void deleteByMatricule(String matricule) {
//        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
//        if (user != null) {
//            utilisateurRepository.delete(user);
//        }
//    }
//
//    public void disableByMatricule(String matricule) {
//        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
//        if (user != null) {
//            user.setStatut(false);
//            utilisateurRepository.save(user);
//        }
//    }
//
//    public void deleteById(Long id) {
//        utilisateurRepository.findById(id).ifPresent(utilisateurRepository::delete);
//    }
//}

// AVEC DTO

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findByMatricule(String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

    public Utilisateur saveFromDTO(UtilisateurDTO dto) {
        Utilisateur u = new Utilisateur();
        u.setMatricule(dto.getMatricule());
        u.setNom(dto.getNom());
        u.setPrenom(dto.getPrenom());
        u.setAdresseMail(dto.getAdresseMail());
        u.setCodePostal(dto.getCodePostal());
        u.setVille(dto.getVille());
        return utilisateurRepository.save(u);
    }

    public Utilisateur updateFromDTO(String matricule, UtilisateurDTO dto) {
        Utilisateur existing = utilisateurRepository.findByMatricule(matricule);
        existing.setNom(dto.getNom());
        existing.setPrenom(dto.getPrenom());
        existing.setAdresseMail(dto.getAdresseMail());
        existing.setCodePostal(dto.getCodePostal());
        existing.setVille(dto.getVille());
        return utilisateurRepository.save(existing);
    }

    public void deleteByMatricule(String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        utilisateurRepository.delete(user);
    }

    public void disableByMatricule(String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        user.setStatut(false);
        utilisateurRepository.save(user);
    }

    public UtilisateurDTO mapToDTO(Utilisateur u) {
        return new UtilisateurDTO(
                u.getMatricule(),
                u.getNom(),
                u.getPrenom(),
                u.getAdresseMail(),
                u.getCodePostal(),
                u.getVille()
        );

    }
}