package com.ofpo.GestionnaireFormation.DTO.utilisateur;

import com.ofpo.GestionnaireFormation.DTO.RoleDTO;

import java.util.List;

/* DTO = Data Transfer Object
L'utilité de creer plusieurs DTO permet de segmenter les données
Utilisé pour transférer les données entre le client et le serveur
contient uniquement les données nécessaires à la création ou à la mise à jour d'une entité ne contient pas de logique métier
utilisé pour éviter de transférer des données inutiles entre le client et le serveur.
Également utilisé pour éviter de transférer des données sensibles entre le client et le serveur */

public class UtilisateurDTO {
    private String matricule;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String codePostal;
    private String ville;
    private List<RoleDTO> roles;

    // Constructeur vide pour Jackson
    public UtilisateurDTO() {
    }

    // Constructeur avec tous les champs
    public UtilisateurDTO(String matricule, String nom, String prenom, String adresseMail, String codePostal, String ville, List<RoleDTO> roles) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.codePostal = codePostal;
        this.ville = ville;
        this.roles = roles;
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

    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}