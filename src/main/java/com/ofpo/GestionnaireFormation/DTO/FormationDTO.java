package com.ofpo.GestionnaireFormation.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDTO {
    private String numeroOffre;
    private String libelle;
    private boolean statut;
}
