package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.formation.FormationDTO;
import com.ofpo.GestionnaireFormation.service.FormationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {
    private final FormationService formationService;

    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    // GET : liste toutes les formations
    @GetMapping("/")
    public List<FormationDTO> getAllFormations() {
        return formationService.getAllFormations();
    }

    // GET : récupère une formation par ID
    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Long id) {
        return formationService.getFormationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST : crée une nouvelle formation
    @PostMapping("/create")
    public ResponseEntity<FormationDTO> createFormation(@RequestBody FormationDTO formationDTO) {
        FormationDTO created = formationService.createFormation(formationDTO);
        return ResponseEntity.ok(created);
    }

    // PUT : met à jour une formation existante
    @PutMapping("/update/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable Long id, @RequestBody FormationDTO formationDTO) {
        FormationDTO updated = formationService.updateFormation(id, formationDTO);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    // DELETE : supprime une formation
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
        return ResponseEntity.noContent().build();
    }
}


//
//    // GET : Récupère une formation spécifique par son ID
//    @GetMapping("/{id}")
//    public FormationDTO findById(@PathVariable Long id) {
//        Formation formation = formationRepository.findById(id).orElse(null);
//        return convertToDTO(formation);
//    }
//
//    // POST : Crée une nouvelle formation (DTO complet envoyé depuis le front)
//    @PostMapping("/create")
//    public FormationDTO add(@RequestBody Formation formation) {
//        formationRepository.save(formation);
//        return convertToDTO(formation);
//    }
//
//    // PUT : Met à jour une formation existante
//    @PutMapping("/update/{id}")
//    public FormationDTO update(@PathVariable Long id, @RequestBody Formation updatedData) {
//        Formation formation = formationRepository.findById(id).orElse(null);
//        if (formation != null) {
//            // On met à jour uniquement les champs simples (les relations peuvent être mises à jour pareil si besoin)
//            formation.setLibelle(updatedData.getLibelle());
//            formation.setNumeroOffre(updatedData.getNumeroOffre());
//            formation.setDateDebut(updatedData.getDateDebut());
//            formation.setDateFin(updatedData.getDateFin());
//            formation.setDateDebutPe(updatedData.getDateDebutPe());
//            formation.setDateFinPe(updatedData.getDateFinPe());
//            formation.setStatut(updatedData.getStatut());
//            formationRepository.save(formation);
//        }
//        return convertToDTO(formation);
//    }
//
//    // DELETE : Supprime une formation par ID
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable Long id) {
//        formationRepository.deleteById(id);
//    }
//
//    // Méthode privée qui convertit une entité Formation en FormationDTO
//    private FormationDTO convertToDTO(Formation formation) {
//        FormationDTO dto = new FormationDTO();
//        dto.setLibelle(formation.getLibelle());
//        dto.setNumeroOffre(formation.getNumeroOffre());
//        dto.setDateDebut(formation.getDateDebut());
//        dto.setDateFin(formation.getDateFin());
//        dto.setDateDebutPe(formation.getDateDebutPe());
//        dto.setDateFinPe(formation.getDateFinPe());
//        dto.setStatut(formation.getStatut());
//
//        // Utilisateurs (ManyToMany simple)
//        dto.setUtilisateurs(
//                formation.getUtilisateurs().stream().map(utilisateur -> {
//                    UtilisateurDTO u = new UtilisateurDTO();
//                    u.setMatricule(utilisateur.getMatricule());
//                    u.setNom(utilisateur.getNom());
//                    u.setPrenom(utilisateur.getPrenom());
//                    u.setAdresseMail(utilisateur.getAdresseMail());
//                    return u;
//                }).collect(Collectors.toList())
//        );
//
//        // Centres (ManyToMany simple)
//        dto.setCentres(
//                formation.getCentres().stream().map(centre -> {
//                    CentreDTO c = new CentreDTO();
//                    c.setNom(centre.getNom());
//                    c.setAdressePostale(centre.getAdressePostale());
//                    c.setVille(centre.getVille());
//                    c.setCodePostal(centre.getCodePostal());
//                    c.setTelephone(centre.getTelephone());
//                    return c;
//                }).collect(Collectors.toList())
//        );
//
//        // Modules (ManyToMany simple)
//        dto.setModules(
//                formation.getModules().stream().map(module -> {
//                    ModuleDTO m = new ModuleDTO();
//                    m.setLibelle(module.getLibelle());
//                    return m;
//                }).collect(Collectors.toList())
//        );
//
//        // Documents (ManyToMany via entité de jointure FormationDocument)
//        dto.setDocuments(
//                formation.getFormationDocuments().stream().map(fd -> {
//                    Document d = fd.getDocument();
//                    DocumentDTO doc = new DocumentDTO();
//                    doc.setLibelle(d.getLibelle());
//                    doc.setDateCreation(d.getDateCreation());
//                    return doc;
//                }).collect(Collectors.toList())
//        );
//
//        // Ressources (ManyToMany via entité de jointure FormationRessource)
//        dto.setRessources(
//                formation.getFormationRessources().stream().map(fr -> {
//                    Ressource r = fr.getRessource();
//                    RessourceDTO res = new RessourceDTO();
//                    res.setLibelle(r.getLibelle());
//                    res.setDateCreation(r.getDateCreation());
//                    res.setDateModification(r.getDateModification());
//                    return res;
//                }).collect(Collectors.toList())
//        );
//
//        return dto;
//    }
