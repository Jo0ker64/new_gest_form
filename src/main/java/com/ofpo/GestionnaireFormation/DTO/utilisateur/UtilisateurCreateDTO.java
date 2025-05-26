package com.ofpo.GestionnaireFormation.DTO.utilisateur;

import com.ofpo.GestionnaireFormation.DTO.RoleDTO;
import com.ofpo.GestionnaireFormation.DTO.formation.FormationDTO;

import java.util.List;

public class UtilisateurCreateDTO {
        private String matricule;
        private String avatar;
        private String nom;
        private String prenom;
        private String adresseMail;
        private String adressePostal;
        private String codePostal;
        private String ville;
        private String motDePasse;
        private Boolean statut;
        private List<FormationDTO> formations;
        private List<RoleDTO> roles;

        public UtilisateurCreateDTO() {
        }

        public UtilisateurCreateDTO(String matricule, String avatar, String nom, String prenom, String adresseMail,
                String adressePostal, String codePostal, String ville, String motDePasse, Boolean statut,
                List<FormationDTO> formations, List<RoleDTO> roles) {
            this.matricule = matricule;
            this.avatar = avatar;
            this.nom = nom;
            this.prenom = prenom;
            this.adresseMail = adresseMail;
            this.adressePostal = adressePostal;
            this.codePostal = codePostal;
            this.ville = ville;
            this.motDePasse = motDePasse;
            this.statut = statut;
            this.formations = formations;
            this.roles = roles;
        }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getAdressePostal() {
        return adressePostal;
    }

    public void setAdressePostal(String adressePostal) {
        this.adressePostal = adressePostal;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public List<FormationDTO> getFormations() {
        return formations;
    }

    public void setFormations(List<FormationDTO> formations) {
        this.formations = formations;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}


