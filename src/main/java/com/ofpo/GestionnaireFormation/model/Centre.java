package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centre")
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adressePostale;
    private String ville;
    private String codePostal;
    private String telephone;

    @ManyToMany(mappedBy = "centres")
    private List<Formation> formations = new ArrayList<>();

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL)
    private List<Salle> salles = new ArrayList<>();

    public Centre() {}

    public Centre(Long id, String nom, String adressePostale, String ville, String codePostal, String telephone) {
        this.id = id;
        this.nom = nom;
        this.adressePostale = adressePostale;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
    }

// Getters & Setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
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

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }
}
