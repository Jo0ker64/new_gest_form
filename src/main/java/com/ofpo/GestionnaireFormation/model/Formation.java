package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
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
}
