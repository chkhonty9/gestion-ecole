package org.cn.etudiantservice.web;

import org.cn.etudiantservice.clients.FiliereRestClient;
import org.cn.etudiantservice.dto.EtudiantDTO;
import org.cn.etudiantservice.service.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;
    private final FiliereRestClient filiereRestClient;

    public EtudiantController(EtudiantService etudiantService, FiliereRestClient filiereRestClient) {
        this.etudiantService = etudiantService;
        this.filiereRestClient = filiereRestClient;
    }

    @GetMapping
    public ResponseEntity<List<EtudiantDTO>> getAllEtudiants() {
        System.out.println("************* controller : getAll etudiants *************");
        List<EtudiantDTO> etudiants = etudiantService.findAll();
        etudiants.forEach(e ->{
            e.setFiliere(filiereRestClient.findFiliereById(e.getIdFiliere()));
        });
        return ResponseEntity.ok(etudiants);
    }

    @PostMapping
    public ResponseEntity<EtudiantDTO> save(@RequestBody EtudiantDTO etudiantDTO) {
        System.out.println("************* controller : save etudiant *************");
        return ResponseEntity.ok(etudiantService.save(etudiantDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudiantDTO> update(@RequestBody EtudiantDTO etudiantDTO, @PathVariable Long id) {
        System.out.println("************* controller : update etudiant *************");
        if(etudiantService.findOne(id) == null)
            return ResponseEntity.notFound().build();
        etudiantDTO.setId(id);
        etudiantDTO = etudiantService.save(etudiantDTO);
        etudiantDTO.setFiliere(filiereRestClient.findFiliereById(etudiantDTO.getIdFiliere()));
        return ResponseEntity.ok(etudiantDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> findOne(@PathVariable Long id) {
        System.out.println("************* controller : find by id etudiant *************");
        EtudiantDTO etudiant = etudiantService.findOne(id);
        etudiant.setFiliere(filiereRestClient.findFiliereById(etudiant.getIdFiliere()));
        return ResponseEntity.ok(etudiant);
    }

    @GetMapping("/cne/{cne}")
    public ResponseEntity<EtudiantDTO> findByCne(@PathVariable String cne) {
        System.out.println("************* controller : find by cne etudiant *************");
        EtudiantDTO etudiant = etudiantService.findByCne(cne);
        etudiant.setFiliere(filiereRestClient.findFiliereById(etudiant.getIdFiliere()));
        return ResponseEntity.ok(etudiant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        System.out.println("************* controller : deleting etudiant *************");
        if(etudiantService.findOne(id) == null)
            return ResponseEntity.notFound().build();

        etudiantService.delete(id);
        return ResponseEntity.ok().build();
    }
}
