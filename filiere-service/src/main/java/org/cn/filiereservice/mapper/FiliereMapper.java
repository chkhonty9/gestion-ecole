package org.cn.filiereservice.mapper;

import org.cn.filiereservice.dto.FiliereDTO;
import org.cn.filiereservice.entities.Filiere;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FiliereMapper {

    public FiliereDTO fromFiliere(Filiere filiere) {
        System.out.println(" *************  mapper : from filiere ********** ");
        FiliereDTO filiereDTO = new FiliereDTO();
        BeanUtils.copyProperties(filiere, filiereDTO);
        return filiereDTO;
    }

    public Filiere toFiliere(FiliereDTO filiereDTO) {
        System.out.println(" *************  mapper : to filiere ********** ");
        Filiere filiere = new Filiere();
        BeanUtils.copyProperties(filiereDTO, filiere);
        return filiere;
    }

}
