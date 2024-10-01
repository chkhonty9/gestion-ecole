package org.cn.etudiantservice.dao;

import org.cn.etudiantservice.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByCneContainingIgnoreCase(String cne);
}
