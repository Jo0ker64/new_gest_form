package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Role;
import com.ofpo.GestionnaireFormation.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Retourne tous les rôles
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    // Retourne un rôle par ID
    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rôle non trouvé avec l'id : " + id));
    }

    // Retourne plusieurs rôles à partir d'une liste d'identifiants
    public List<Role> findAllByIds(List<Long> ids) {
        return roleRepository.findAllById(ids);
    }

    // Sauvegarde ou met à jour un rôle
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    // Supprime un rôle
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
