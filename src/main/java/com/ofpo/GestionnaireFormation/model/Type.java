package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "type")
    private List<Ressource> ressources = new ArrayList<>();

    public Type() {}

    public Type(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    // Getters & Setters
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

    public List<Ressource> getRessources() {
        return ressources;
    }
    public void setRessources(List<Ressource> ressources) {
        this.ressources = ressources;
    }
}
