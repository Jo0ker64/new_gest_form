package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.model.Type;
import com.ofpo.GestionnaireFormation.service.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/")
    public List<Type> getAll() {
        return typeService.findAll();
    }

    @GetMapping("/{id}")
    public Type getById(@PathVariable Long id) {
        return typeService.findById(id);
    }

    @PostMapping("/create")
    public Type create(@RequestBody Type type) {
        return typeService.save(type);
    }

    @PutMapping("/update/{id}")
    public Type update(@PathVariable Long id, @RequestBody Type type) {
        type.setId(id);
        return typeService.save(type);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        typeService.deleteById(id);
    }
}
