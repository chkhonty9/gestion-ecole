package org.cn.filiereservice.web;


import lombok.AllArgsConstructor;
import org.cn.filiereservice.dto.FiliereDTO;
import org.cn.filiereservice.service.FiliereService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filieres")
@AllArgsConstructor
public class FiliereController {

    FiliereService filiereService;

    @GetMapping
    public ResponseEntity<List<FiliereDTO>> findAll() {
        System.out.println(" *************  controller : finding all filieres ********** ");
        return ResponseEntity.ok(filiereService.findAll());
    }

    @PostMapping
    public ResponseEntity<FiliereDTO> save(@RequestBody FiliereDTO f) {
        System.out.println(" *************  controller : saving filiere ********** ");
        return ResponseEntity.ok(filiereService.save(f));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiliereDTO> update(@RequestBody FiliereDTO filiere, @PathVariable Long id) {
        System.out.println(" *************  controller : updating filiere ********** ");
        FiliereDTO f = filiereService.findOne(id);
        if(filiereService.findOne(id) == null) {
            return ResponseEntity.notFound().build();
        }

        filiere.setId(id);
        return ResponseEntity.ok(filiereService.save(filiere));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FiliereDTO> findOne(@PathVariable Long id) {
        System.out.println(" *************  controller : finding filiere ********** ");
        if(filiereService.findOne(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filiereService.findOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        System.out.println(" *************  controller : deleting filiere ********** ");
        if(filiereService.findOne(id) == null) {
            return ResponseEntity.notFound().build();
        }

        filiereService.delete(id);
        return ResponseEntity.ok().build();
    }

}
