package com.ofpo.GestionnaireFormation.repository;

import com.ofpo.GestionnaireFormation.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {
}
