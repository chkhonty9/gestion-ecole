package org.cn.etudiantservice.entities;

import lombok.*;
import org.cn.etudiantservice.dto.Filiere;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String cne;
    private Long idFiliere;
    @Transient
    private Filiere filiere;
}
