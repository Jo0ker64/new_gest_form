package com.ofpo.GestionnaireFormation.DTO.formation;

import com.ofpo.GestionnaireFormation.DTO.CentreDTO;
import com.ofpo.GestionnaireFormation.DTO.DocumentDTO;
import com.ofpo.GestionnaireFormation.DTO.ModuleDTO;
import com.ofpo.GestionnaireFormation.DTO.RessourceDTO;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurDTO;

import java.util.Date;
import java.util.List;


public class FormationDTO {
    private Long id;
    private String libelle;
    private String numeroOffre;
    private Date dateDebut;
    private Date dateFin;
    private Date dateDebutPe;
    private Date dateFinPe;
    private Boolean statut;
    List<RessourceDTO> ressources;
    List<ModuleDTO> modules;
    List<CentreDTO> centres;
    List<DocumentDTO> documents;
    List<UtilisateurDTO> utilisateurs;

    // Constructeur vide pour Jackson
    public FormationDTO() {
    }

    // Constructeur avec tous les champs
    public FormationDTO(Long id,
                        String libelle,
                        String numeroOffre,
                        Date dateDebut,
                        Date dateFin,
                        Date dateDebutPe,
                        Date dateFinPe,
                        Boolean statut,
                        List<RessourceDTO> ressources,
                        List<ModuleDTO> modules,
                        List<CentreDTO> centres,
                        List<DocumentDTO> documents,
                        List<UtilisateurDTO> utilisateurs
    ) {
        this.id = id;
        this.libelle = libelle;
        this.numeroOffre = numeroOffre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dateDebutPe = dateDebutPe;
        this.dateFinPe = dateFinPe;
        this.statut = statut;
        this.ressources = ressources;
        this.modules = modules;
        this.centres = centres;
        this.documents = documents;
        this.utilisateurs = utilisateurs;

    }

    // Getters et Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNumeroOffre() {
        return numeroOffre;
    }

    public void setNumeroOffre(String numeroOffre) {
        this.numeroOffre = numeroOffre;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebutPe() {
        return dateDebutPe;
    }

    public void setDateDebutPe(Date dateDebutPe) {
        this.dateDebutPe = dateDebutPe;
    }

    public Date getDateFinPe() {
        return dateFinPe;
    }

    public void setDateFinPe(Date dateFinPe) {
        this.dateFinPe = dateFinPe;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public List<RessourceDTO> getRessources() {
        return ressources;
    }

    public void setRessources(List<RessourceDTO> ressources) {
        this.ressources = ressources;
    }

    public List<ModuleDTO> getModules() {
        return modules;
    }

    public void setModules(List<ModuleDTO> modules) {
        this.modules = modules;
    }

    public List<CentreDTO> getCentres() {
        return centres;
    }

    public void setCentres(List<CentreDTO> centres) {
        this.centres = centres;
    }

    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }

    public List<UtilisateurDTO> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<UtilisateurDTO> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
