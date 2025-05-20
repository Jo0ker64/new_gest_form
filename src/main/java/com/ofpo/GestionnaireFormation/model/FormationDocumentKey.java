package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class FormationDocumentKey implements Serializable {

    @Column(name = "id_formation")
    private Long formationId;

    @Column(name = "id_document")
    private Long documentId;

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
}
