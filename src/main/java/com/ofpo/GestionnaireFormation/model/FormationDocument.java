package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "formation_document")
public class FormationDocument {

    @EmbeddedId
    private FormationDocumentKey id = new FormationDocumentKey();

    @ManyToOne
    @MapsId("formationId")
    @JoinColumn(name = "id_formation")
    private Formation formation;

    @ManyToOne
    @MapsId("documentId")
    @JoinColumn(name = "id_document")
    private Document document;

    private Date dateGeneration;
    private Date dateTelechargement;
}
