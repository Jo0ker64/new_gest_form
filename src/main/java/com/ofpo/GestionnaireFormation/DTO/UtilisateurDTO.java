package com.ofpo.GestionnaireFormation.DTO;

import com.ofpo.GestionnaireFormation.model.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

// DTO = Data Transfer Object
// Utilisé pour transférer les données entre le client et le serveur
// contient uniquement les données nécessaires à la création ou à la mise à jour d'une entité
// ne contient pas de logique métier
// utilisé pour éviter de transférer des données inutiles entre le client et le serveur et
// également utilisé pour éviter de transférer des données sensibles entre le client et le serveur

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {
    private String matricule;
    private String avatar;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String adressePostal;
    private String codePostal;
    private String ville;
    private String motDePasse;
    private Boolean statut;
}