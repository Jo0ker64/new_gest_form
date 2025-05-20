package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.RoleDTO;
import com.ofpo.GestionnaireFormation.model.Role;
import com.ofpo.GestionnaireFormation.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public List<RoleDTO> findAll() {
        return roleService.findAll().stream()
                .map(r -> new RoleDTO(r.getLibelle()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RoleDTO findById(@PathVariable Long id) {
        Role role = roleService.findById(id);
        return new RoleDTO(role.getLibelle());
    }

    @PostMapping("/create")
    public RoleDTO add(@RequestBody RoleDTO dto) {
        Role role = new Role();
        role.setLibelle(dto.getLibelle());
        Role saved = roleService.save(role);
        return new RoleDTO(saved.getLibelle());
    }

    @PutMapping("/update/{id}")
    public RoleDTO update(@PathVariable Long id, @RequestBody RoleDTO dto) {
        Role updated = roleService.updateFromDTO(id, dto);
        return new RoleDTO(updated.getLibelle());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        roleService.deleteById(id);
    }

    @PutMapping("/disable/{id}")
    public void disable(@PathVariable Long id) {
        roleService.disable(id);
    }
}