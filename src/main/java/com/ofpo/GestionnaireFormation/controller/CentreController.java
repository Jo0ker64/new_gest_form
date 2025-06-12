package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.CentreDTO;
import com.ofpo.GestionnaireFormation.service.CentreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centres")
public class CentreController {

    private final CentreService centreService;

    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }

    @GetMapping("/")
    public List<CentreDTO> getAll() {
        return centreService.getAllCentres();
    }

    @GetMapping("/{id}")
    public CentreDTO getById(@PathVariable Long id) {
        return centreService.getCentreById(id).orElse(null);
    }

    @PostMapping("/create")
    public CentreDTO create(@RequestBody CentreDTO dto) {
        return centreService.createCentre(dto);
    }

    @PutMapping("/update/{id}")
    public CentreDTO update(@PathVariable Long id, @RequestBody CentreDTO dto) {
        return centreService.updateCentre(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        centreService.deleteCentre(id);
    }
}
