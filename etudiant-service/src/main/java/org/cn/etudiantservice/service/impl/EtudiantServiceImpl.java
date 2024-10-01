package org.cn.etudiantservice.service.impl;

import lombok.AllArgsConstructor;
import org.cn.etudiantservice.dao.EtudiantRepository;
import org.cn.etudiantservice.dto.EtudiantDTO;
import org.cn.etudiantservice.mapper.EtudiantMapper;
import org.cn.etudiantservice.service.EtudiantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;

    @Override
    public EtudiantDTO save(EtudiantDTO etudiantDTO) {
        System.out.println("************* service : saving etudiant **********");
        return etudiantMapper.fromEtudiant(etudiantRepository.save(etudiantMapper.toEtudiant(etudiantDTO)));
    }

    @Override
    public List<EtudiantDTO> findAll() {
        System.out.println("************* service : finding all etudiant **********");
        return etudiantRepository.findAll().stream().map(etudiantMapper::fromEtudiant).collect(Collectors.toList());
    }

    @Override
    public EtudiantDTO findOne(Long id) {
        System.out.println("************* service : find etudiant **********");
        return etudiantMapper.fromEtudiant(etudiantRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Long id) {
        System.out.println("************* service : deleting etudiant **********");
        etudiantRepository.deleteById(id);
    }

    @Override
    public EtudiantDTO findByCne(String cne) {
        System.out.println("************* service : find etudiant by cne **********");
        return etudiantMapper.fromEtudiant(etudiantRepository.findByCneContainingIgnoreCase(cne));
    }
}
