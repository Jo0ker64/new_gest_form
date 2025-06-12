package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.RoleDTO;
import com.ofpo.GestionnaireFormation.model.Role;
import com.ofpo.GestionnaireFormation.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.hibernate.Hibernate.map;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;
    private RoleDTO roleDTO;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public List<RoleDTO> findAll() {
        return roleService.findAll().stream()
                .map(roleService::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RoleDTO findById(@PathVariable Long id) {
        return roleService.mapToDTO(
                roleService.findById(id));
    }

    @PostMapping("/create")
    public RoleDTO add(@RequestBody RoleDTO dto) {
        Role saved = roleService.saveFromDTO(dto);
        return roleDTO;
    }

    @PutMapping("/update/{id}")
    public RoleDTO update(@PathVariable Long id, @RequestBody RoleDTO dto) {
        Role updated = roleService.updateFromDTO(id, dto);
        return roleService.mapToDTO(updated);
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