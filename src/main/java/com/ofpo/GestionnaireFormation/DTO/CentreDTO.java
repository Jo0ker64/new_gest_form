package com.ofpo.GestionnaireFormation.DTO;

import com.ofpo.GestionnaireFormation.DTO.formation.FormationDTO;
import com.ofpo.GestionnaireFormation.model.Salle;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

public class CentreDTO {

    private String nom;
    private String adressePostal;
    private String ville;
    private String codePostal;
    private String telephone;

    List<FormationDTO> formations;
    List<SalleDTO> salles;

    public CentreDTO() {
    }

    public CentreDTO(String nom, String adressePostal, String ville, String codePostal, String telephone, List<FormationDTO> formations, List<SalleDTO> salles) {
        this.nom = nom;
        this.adressePostal = adressePostal;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.formations = formations;
        this.salles = salles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdressePostal() {
        return adressePostal;
    }

    public void setAdressePostal(String adressePostal) {
        this.adressePostal = adressePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<FormationDTO> getFormations() {
        return formations;
    }

    public void setFormations(List<FormationDTO> formations) {
        this.formations = formations;
    }

    public List<SalleDTO> getSalles() {
        return salles;
    }

    public void setSalles(List<SalleDTO> salles) {
        this.salles = salles;
    }
}
