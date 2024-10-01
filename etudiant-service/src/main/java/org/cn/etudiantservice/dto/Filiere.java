package org.cn.etudiantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Filiere {
    private Long id;
    private String code;
    private String libelle;
}
