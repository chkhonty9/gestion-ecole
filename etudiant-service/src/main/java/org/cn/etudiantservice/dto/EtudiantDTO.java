package org.cn.etudiantservice.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String cne;
    private Long idFiliere;
    private Filiere filiere;
}
