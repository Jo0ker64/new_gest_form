package com.ofpo.GestionnaireFormation.DTO.utilisateur;

public class UtilisateurUpdateDTO {
    private String matricule;
    private String nom;
    private String prenom;
    private String adresseMail;
    private Boolean statut;

    public UtilisateurUpdateDTO() {
    }

    public UtilisateurUpdateDTO(String matricule, String nom, String prenom, String adresseMail,
            String adressePostal, Boolean statut) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.statut = statut;
    }

    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }
}
