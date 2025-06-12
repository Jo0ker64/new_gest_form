package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private Date dateCreation;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FormationDocument> formationDocuments = new ArrayList<>();

    // Constructors
    public Document(Long id, String libelle, Date dateCreation) {
        this.id = id;
        this.libelle = libelle;
        this.dateCreation = dateCreation;
    }
    public Document() {
    }

    // Getters and Setters

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

    public List<FormationDocument> getFormationDocuments() {
        return formationDocuments;
    }

    public void setFormationDocuments(List<FormationDocument> formationDocuments) {
        this.formationDocuments = formationDocuments;
    }
}
