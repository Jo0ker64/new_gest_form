package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private Boolean statut;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    public Role() {
    }

    public Role(Long id, String libelle, Boolean statut, List<Utilisateur> utilisateurs) {
        this.id = id;
        this.libelle = libelle;
        this.statut = statut;
        this.utilisateurs = utilisateurs;
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

}
