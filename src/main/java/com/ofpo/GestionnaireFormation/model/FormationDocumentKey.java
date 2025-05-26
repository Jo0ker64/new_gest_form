package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FormationDocumentKey implements Serializable {

    @Column(name = "id_formation")
    private Long formationId;

    @Column(name = "id_document")
    private Long documentId;

    public FormationDocumentKey() {
    }


    // equals() et hashCode() obligatoires pour les clés composites
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormationDocumentKey)) return false;
        FormationDocumentKey that = (FormationDocumentKey) o;
        return Objects.equals(formationId, that.formationId) &&
                Objects.equals(documentId, that.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formationId, documentId);
    }

    // Getters and Setters
    public Long getFormationId() {
        return formationId;
    }
    public void setFormationId(Long formationId) {
        this.formationId = formationId;
    }

    public Long getDocumentId() {
        return documentId;
    }
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }
}
