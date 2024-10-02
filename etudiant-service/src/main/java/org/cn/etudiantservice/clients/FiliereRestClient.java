package org.cn.etudiantservice.clients;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.cn.etudiantservice.dto.Filiere;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "FILIERE-SERVICE")
public interface FiliereRestClient {

    @GetMapping("/api/v1/filieres/{id}")
    @CircuitBreaker(name = "filiereService", fallbackMethod = "getDefaultFiliere")
    Filiere findFiliereById(@PathVariable Long id);

    @GetMapping("/api/v1/filieres")
    @CircuitBreaker(name = "filiereService", fallbackMethod = "getAllFilieres")
    List<Filiere> allFilieres();

    default Filiere getDefaultFiliere(Long id, Exception exception) {
        Filiere filiere = new Filiere();
        filiere.setId(id);
        filiere.setCode("not available");
        filiere.setLibelle("not available");
        return filiere;

    }

    default  List<Filiere> getAllFilieres(Exception exception) {
        return List.of();
    }

}
