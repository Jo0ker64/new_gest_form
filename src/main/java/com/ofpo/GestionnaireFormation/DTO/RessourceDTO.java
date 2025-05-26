package com.ofpo.GestionnaireFormation.DTO;

import com.ofpo.GestionnaireFormation.model.Type;

import java.util.Date;

public class RessourceDTO {
    private Long id;
    private String libelle;
    private Date dateCreation;
    private Date dateModification;
    private Long typeId;
    private String typeLibelle;

    // Constructors
    public RessourceDTO(Long id,
                        String libelle,
                        Date dateCreation,
                        Date dateModification,
                        Type type) {
        this.id = id;
        this.libelle = libelle;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.typeId = typeId;
        this.typeLibelle = typeLibelle;
    }

    public RessourceDTO(Long id, String libelle, Date dateCreation, Date dateModification, Long aLong, String s) {
    }

    public RessourceDTO() {

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

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeLibelle() {
        return typeLibelle;
    }

    public void setTypeLibelle(String typeLibelle) {
        this.typeLibelle = typeLibelle;
    }
}
