package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "formation_ressource")
public class FormationRessource {

    @EmbeddedId
    private FormationRessourceKey id = new FormationRessourceKey();

    @ManyToOne
    @MapsId("formationId")
    @JoinColumn(name = "id_formation")
    private Formation formation;

    @ManyToOne
    @MapsId("ressourceId")
    @JoinColumn(name = "id_ressource")
    private Ressource ressource;

    private Date dateAjout;

    public FormationRessource() {}

    public FormationRessource(Formation formation, Ressource ressource, Date dateAjout) {
        this.formation = formation;
        this.ressource = ressource;
        this.dateAjout = dateAjout;
        this.id = new FormationRessourceKey(formation.getId(), ressource.getId());
    }

    // Getters & Setters...
    public FormationRessourceKey getId() {
        return id;
    }
    public void setId(FormationRessourceKey id) {
        this.id = id;
    }

    public Formation getFormation() {
        return formation;
    }
    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Ressource getRessource() {
        return ressource;
    }
    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public Date getDateAjout() {
        return dateAjout;
    }
    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }
}
