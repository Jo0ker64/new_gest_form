package com.ofpo.GestionnaireFormation.DTO;

import com.ofpo.GestionnaireFormation.DTO.utilisateur.UtilisateurDTO;

import java.util.List;


public class RoleDTO {
    private Long id;
    private String libelle;
    private Boolean statut;
    private List<UtilisateurDTO> utilisateurs; // Commenté pour éviter la récursivité infinie


    public RoleDTO(String libelle) {
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

    public List<UtilisateurDTO> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<UtilisateurDTO> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
