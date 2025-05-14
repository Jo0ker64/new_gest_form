package com.ofpo.GestionnaireFormation.repository;

import com.ofpo.GestionnaireFormation.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Long> {
}
