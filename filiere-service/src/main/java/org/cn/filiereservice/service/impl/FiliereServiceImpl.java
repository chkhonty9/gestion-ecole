package org.cn.filiereservice.service.impl;

import lombok.AllArgsConstructor;
import org.cn.filiereservice.dao.FiliereRepository;
import org.cn.filiereservice.dto.FiliereDTO;
import org.cn.filiereservice.mapper.FiliereMapper;
import org.cn.filiereservice.service.FiliereService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class FiliereServiceImpl implements FiliereService {

    private FiliereRepository repository;
    private FiliereMapper mapper;

    @Override
    public FiliereDTO save(FiliereDTO f) {
        System.out.println(" *************  service : saving filiere ********** ");
        return mapper.fromFiliere(repository.save(mapper.toFiliere(f)));
    }

    @Override
    public FiliereDTO findOne(Long id) {
        System.out.println(" *************  service : finding filiere ********** ");
        return mapper.fromFiliere(repository.findById(id).orElse(null));
    }

    @Override
    public List<FiliereDTO> findAll() {
        System.out.println(" *************  service : finding all filieres ********** ");
        return repository.findAll().stream().map(f -> mapper.fromFiliere(f)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        System.out.println(" *************  service : deleting filiere ********** ");
        repository.deleteById(id);
    }
}
