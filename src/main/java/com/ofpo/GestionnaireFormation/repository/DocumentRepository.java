package com.ofpo.GestionnaireFormation.repository;

import com.ofpo.GestionnaireFormation.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
