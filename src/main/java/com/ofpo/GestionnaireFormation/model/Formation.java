package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private String numeroOffre;
    private Date dateDebut;
    private Date dateFin;
    private Date dateDebutPe;
    private Date dateFinPe;
    private Boolean statut;

    // --- Utilisateurs (simple ManyToMany)
    @ManyToMany
    @JoinTable(
            name = "utilisateur_formation_fonction",
            joinColumns = @JoinColumn(name = "id_formation"),
            inverseJoinColumns = @JoinColumn(name = "id_utilisateur")
    )
    @JsonIgnore
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    // --- Centres (simple ManyToMany)
    @ManyToMany
    @JoinTable(
            name = "formation_centre",
            joinColumns = @JoinColumn(name = "id_formation"),
            inverseJoinColumns = @JoinColumn(name = "id_centre")
    )
    @JsonIgnore
    private List<Centre> centres = new ArrayList<>();

    // --- Modules (simple ManyToMany)
    @ManyToMany
    @JoinTable(
            name = "formation_module",
            joinColumns = @JoinColumn(name = "id_formation"),
            inverseJoinColumns = @JoinColumn(name = "id_module")
    )
    @JsonIgnore
    private List<Module> modules = new ArrayList<>();

    // --- Documents (entité intermédiaire avec données supplémentaires)
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FormationDocument> formationDocuments = new ArrayList<>();

    // --- Ressources (entité intermédiaire avec données supplémentaires)
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FormationRessource> formationRessources = new ArrayList<>();

    // constructeur vide pour JPA
    public Formation() {
    }

    // constructeur avec tous les champs
    public Formation(String libelle,
                        String numeroOffre,
                        Date dateDebut,
                        Date dateFin,
                        Date dateDebutPe,
                        Date dateFinPe,
                        Boolean statut,
                        List<Utilisateur> utilisateurs,
                        List<Centre> centres,
                        List<Module> modules,
                        List<FormationDocument> documents,
                        List<FormationRessource> ressources
    ) {
        this.libelle = libelle;
        this.numeroOffre = numeroOffre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dateDebutPe = dateDebutPe;
        this.dateFinPe = dateFinPe;
        this.statut = statut;
        this.utilisateurs = utilisateurs;
        this.centres = centres;
        this.modules = modules;
        this.formationDocuments = documents;
        this.formationRessources = ressources;
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

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public List<Centre> getCentres() {
        return centres;
    }
    public void setCentres(List<Centre> centres) {
        this.centres = centres;
    }

    public List<Module> getModules() {
        return modules;
    }
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<FormationDocument> getFormationDocuments() {
        return formationDocuments;
    }
    public void setFormationDocuments(List<FormationDocument> formationDocuments) {
        this.formationDocuments = formationDocuments;
    }

    public List<FormationRessource> getFormationRessources() {
        return formationRessources;
    }

    public void setFormationRessources(List<FormationRessource> formationRessources) {
        this.formationRessources = formationRessources;
    }
}
