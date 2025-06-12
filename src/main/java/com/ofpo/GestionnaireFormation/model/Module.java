package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @ManyToMany(mappedBy = "modules")
    @JsonIgnore
    private List<Formation> formations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "module_sequence",
            joinColumns = @JoinColumn(name = "id_module"),
            inverseJoinColumns = @JoinColumn(name = "id_sequence")
    )
    @JsonIgnore
    private List<Sequence> sequences = new ArrayList<>();

    public Module() {
    }

    public Module(Long id, String libelle, List<Formation> formations, List<Sequence> sequences) {
        this.id = id;
        this.libelle = libelle;
        this.formations = formations;
        this.sequences = sequences;
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

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Sequence> getSequences() {
        return sequences;
    }

    public void setSequences(List<Sequence> sequences) {
        this.sequences = sequences;
    }
}

