package org.cn.etudiantservice.web;

import lombok.AllArgsConstructor;
import org.cn.etudiantservice.dto.EtudiantDTO;
import org.cn.etudiantservice.service.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiants")
@AllArgsConstructor
public class EtudiantController {

    private final EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<EtudiantDTO>> getAllEtudiants() {
        System.out.println("************* controller : getAll etudiants *************");
        return ResponseEntity.ok(etudiantService.findAll());
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
        return ResponseEntity.ok(etudiantService.save(etudiantDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> findOne(@PathVariable Long id) {
        System.out.println("************* controller : find by id etudiant *************");
        return ResponseEntity.ok(etudiantService.findOne(id));
    }

    @GetMapping("/cne/{cne}")
    public ResponseEntity<EtudiantDTO> findByCne(@PathVariable String cne) {
        System.out.println("************* controller : find by cne etudiant *************");
        return ResponseEntity.ok(etudiantService.findByCne(cne));
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
