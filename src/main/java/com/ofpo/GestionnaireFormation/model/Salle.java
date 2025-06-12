package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @ManyToOne
    @JoinColumn(name = "id_centre")
    @JsonIgnore
    private Centre centre;

    public Salle() {
    }

    public Salle(Long id,
                    String libelle,
                    Centre centre) {
        this.id = id;
        this.libelle = libelle;
        this.centre = centre;
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

    public Centre getCentre() {
        return centre;
    }
    public void setCentre(Centre centre) {
        this.centre = centre;
    }
}
