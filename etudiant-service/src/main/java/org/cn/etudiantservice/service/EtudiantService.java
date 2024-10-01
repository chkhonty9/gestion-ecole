package org.cn.etudiantservice.service;

import org.cn.etudiantservice.dto.EtudiantDTO;

import java.util.List;

public interface EtudiantService {

    EtudiantDTO save(EtudiantDTO etudiantDTO);
    List<EtudiantDTO> findAll();
    EtudiantDTO findOne(Long id);
    void delete(Long id);
    EtudiantDTO findByCne(String cne);
}
