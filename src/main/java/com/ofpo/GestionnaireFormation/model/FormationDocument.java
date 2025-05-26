package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

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

    public FormationDocument() {
    }

    public FormationDocument(FormationDocumentKey id, Formation formation, Document document, Date dateGeneration, Date dateTelechargement) {
        this.id = id;
        this.formation = formation;
        this.document = document;
        this.dateGeneration = dateGeneration;
        this.dateTelechargement = dateTelechargement;
    }

    public FormationDocumentKey getId() {
        return id;
    }

    public void setId(FormationDocumentKey id) {
        this.id = id;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Date getDateGeneration() {
        return dateGeneration;
    }

    public void setDateGeneration(Date dateGeneration) {
        this.dateGeneration = dateGeneration;
    }

    public Date getDateTelechargement() {
        return dateTelechargement;
    }

    public void setDateTelechargement(Date dateTelechargement) {
        this.dateTelechargement = dateTelechargement;
    }
}
