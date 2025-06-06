package com.ofpo.GestionnaireFormation.repository;

import com.ofpo.GestionnaireFormation.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, Long> {
}
