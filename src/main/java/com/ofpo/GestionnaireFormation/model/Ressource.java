package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ressource")
public class Ressource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private Date dateCreation;
    private Date dateModification;

    @ManyToOne
    @JoinColumn(name = "id_type")
    @JsonIgnore
    private Type type;

    @OneToMany(mappedBy = "ressource", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FormationRessource> formationRessources = new ArrayList<>();
}
