package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.CentreDTO;
import com.ofpo.GestionnaireFormation.model.Centre;
import com.ofpo.GestionnaireFormation.service.CentreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/centres")
public class CentreController {

    private final CentreService centreService;

    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }

    @GetMapping("/")
    public List<CentreDTO> findAll() {
        return centreService.findAll().stream()
                .map(c -> new CentreDTO(c.getNom(), c.getVille()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CentreDTO findById(@PathVariable Long id) {
        Centre c = centreService.findById(id);
        return new CentreDTO(c.getNom(), c.getVille());
    }

    @PostMapping("/create")
    public CentreDTO create(@RequestBody CentreDTO dto) {
        Centre centre = new Centre();
        centre.setNom(dto.getNom());
        centre.setVille(dto.getVille());
        Centre saved = centreService.save(centre);
        return new CentreDTO(saved.getNom(), saved.getVille());
    }

    @PutMapping("/update/{id}")
    public CentreDTO update(@PathVariable Long id, @RequestBody CentreDTO dto) {
        Centre updated = centreService.updateFromDTO(id, dto);
        return new CentreDTO(updated.getNom(), updated.getVille());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        centreService.deleteById(id);
    }
}