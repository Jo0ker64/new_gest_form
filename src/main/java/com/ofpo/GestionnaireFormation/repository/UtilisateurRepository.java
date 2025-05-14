package com.ofpo.GestionnaireFormation.repository;

import com.ofpo.GestionnaireFormation.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByMatricule(String matricule);
}
