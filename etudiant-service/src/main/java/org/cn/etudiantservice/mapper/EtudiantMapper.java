package org.cn.etudiantservice.mapper;

import org.cn.etudiantservice.dto.EtudiantDTO;
import org.cn.etudiantservice.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EtudiantMapper {

    public EtudiantDTO fromEtudiant(Etudiant etudiant) {

        System.out.println("******** mapper : from etudiant *********");

        EtudiantDTO etudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(etudiant, etudiantDTO);
        etudiantDTO.setFiliere(etudiant.getFiliere());
        return etudiantDTO;
    }

    public Etudiant toEtudiant(EtudiantDTO etudiantDTO) {

        System.out.println("******** mapper : to etudiant *********");

        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantDTO, etudiant);
        etudiant.setFiliere(etudiantDTO.getFiliere());
        return etudiant;
    }
}
