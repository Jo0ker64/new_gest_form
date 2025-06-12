package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String adressePostal;
    private String ville;
    private String codePostal;
    private String telephone;

    @ManyToMany(mappedBy = "centres")
    @JsonIgnore
    private List<Formation> formations = new ArrayList<>();

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Salle> salles = new ArrayList<>();

    public Centre() {
    }

    public Centre(Long id, String nom, String adressePostal, String ville, String codePostal, String telephone, List<Formation> formations, List<Salle> salles) {
        this.id = id;
        this.nom = nom;
        this.adressePostal = adressePostal;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.formations = formations;
        this.salles = salles;
    }

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

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }
}
