package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.DTO.RoleDTO;
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

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role non trouvé"));
    }

    public Role saveFromDTO(RoleDTO dto) {
        Role r = new Role();
        r.setLibelle(dto.getLibelle());
        r.setStatut(dto.getStatut());
        return roleRepository.save(r);
    }

    public Role updateFromDTO(Long id, RoleDTO dto) {
        Role r = findById(id);
        r.setLibelle(dto.getLibelle());
        r.setStatut(dto.getStatut());
        return roleRepository.save(r);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public void disable(Long id) {
        Role r = findById(id);
        r.setStatut(false);
        roleRepository.save(r);
    }

    public RoleDTO mapToDTO(Role r) {
        return new RoleDTO(
                r.getLibelle()
        );
    }
}