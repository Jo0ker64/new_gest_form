
package com.ofpo.GestionnaireFormation.repository;

import com.ofpo.GestionnaireFormation.model.Role;
import com.ofpo.GestionnaireFormation.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByMatricule(String matricule);

    List<Utilisateur> findByRoles(Role role);

    List<Utilisateur> findByRolesId(Long id);
}
