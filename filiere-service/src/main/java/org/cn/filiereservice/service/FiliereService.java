package org.cn.filiereservice.service;

import org.cn.filiereservice.dto.FiliereDTO;

import java.util.List;

public interface FiliereService {
    FiliereDTO save(FiliereDTO f);
    FiliereDTO findOne(Long id);
    List<FiliereDTO> findAll();
    void delete(Long id);
}
