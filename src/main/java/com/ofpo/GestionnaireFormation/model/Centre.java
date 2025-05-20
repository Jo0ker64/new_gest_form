package com.ofpo.GestionnaireFormation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "centre")
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adressePostal;
    private String ville;
    private String codePostal;
    private String telephone;

    @ManyToMany(mappedBy = "centres")
    @JsonIgnore
    private List<Formation> formations = new ArrayList<>();

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Salle> salles = new ArrayList<>();

}
