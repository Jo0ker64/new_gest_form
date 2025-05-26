package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ressource")
public class Ressource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private Date dateCreation;
    private Date dateModification;

    @ManyToOne
    @JoinColumn(name = "id_type")
    @JsonIgnore
    private Type type;

    @OneToMany(mappedBy = "ressource", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FormationRessource> formationRessources = new ArrayList<>();

    public Ressource() {
    }

    public Ressource(Long id,
                        String libelle,
                        Date dateCreation,
                        Date dateModification,
                        Type type,
                        List<FormationRessource> formationRessources) {
        this.id = id;
        this.libelle = libelle;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.type = type;
        this.formationRessources = formationRessources;
    }

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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<FormationRessource> getFormationRessources() {
        return formationRessources;
    }

    public void setFormationRessources(List<FormationRessource> formationRessources) {
        this.formationRessources = formationRessources;
    }
}
