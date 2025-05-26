package com.ofpo.GestionnaireFormation.DTO;

public class SalleDTO {

    private Long id;
    private String libelle;

    public SalleDTO() {
    }

    public SalleDTO(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
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
}
