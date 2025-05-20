package com.ofpo.GestionnaireFormation.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class FormationRessourceKey implements Serializable {

    private Long formationId;
    private Long ressourceId;

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormationRessourceKey)) return false;
        FormationRessourceKey that = (FormationRessourceKey) o;
        return Objects.equals(formationId, that.formationId) &&
                Objects.equals(ressourceId, that.ressourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formationId, ressourceId);
    }
}
