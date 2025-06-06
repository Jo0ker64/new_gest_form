package com.ofpo.GestionnaireFormation.repository;

import com.ofpo.GestionnaireFormation.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
