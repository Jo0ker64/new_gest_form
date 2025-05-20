package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
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
}
