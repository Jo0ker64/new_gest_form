package com.ofpo.GestionnaireFormation.DTO;

import com.ofpo.GestionnaireFormation.DTO.ModuleDTO;
import java.util.List;

public class SequenceDTO {
    private Long id;
    private String libelle;
    List<ModuleDTO> modulesDTOs;

    public SequenceDTO() {
    }

    public SequenceDTO(Long id, String libelle, List<ModuleDTO> modulesDTOs) {
        this.id = id;
        this.libelle = libelle;
        this.modulesDTOs = modulesDTOs;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<ModuleDTO> getModulesDTOs() {
        return modulesDTOs;
    }
    public void setModulesDTOs(List<ModuleDTO> modulesDTOs) {
        this.modulesDTOs = modulesDTOs;
    }

}
