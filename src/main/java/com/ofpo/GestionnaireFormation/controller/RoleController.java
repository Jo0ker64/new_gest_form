package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Role;
import com.ofpo.GestionnaireFormation.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // retourne la liste complète des rôles
    @GetMapping("/")
    public String findAll() {
        return roleRepository.findAll().toString();
    }
    // retourne un rôle via son id
    @GetMapping("/{id}")
    public String findById(@PathVariable Long id) {
        return roleRepository.findById(id).toString();
    }

    // crée un rôle
    @PostMapping("/create")
    public void add(@RequestBody Role role) {
        roleRepository.save(role);
    }

    // modifie un rôle
    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Role role) {
        Optional<Role> existingRole = roleRepository.findById(id);
    }

    // supprime un rôle
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            roleRepository.delete(role.get());
        }
    }

    // désactive un rôle
    @PutMapping("/disable/{id}")
    public void disable(@PathVariable Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role != null) {
            Role r = role.get();
            r.setStatut(false);
            roleRepository.save(r);
        }

    }
}