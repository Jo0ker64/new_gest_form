package com.ofpo.GestionnaireFormation.DTO;

import java.util.Date;

public class DocumentDTO {
    private Long id;
    private String libelle;
    private Date dateCreation;

    // Constructors
    public DocumentDTO(Long id, String libelle, Date dateCreation) {
        this.id = id;
        this.libelle = libelle;
        this.dateCreation = dateCreation;
    }
    public DocumentDTO() {
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
}
