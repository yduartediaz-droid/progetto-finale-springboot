package com.awy.progettofinalespringboot.features.utente;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    @GetMapping
    public List<UtenteEntity> getAll() {
        return utenteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtenteEntity> getById(@PathVariable Long id) {
        UtenteEntity utente = utenteService.getById(id);
        return utente != null ? ResponseEntity.ok(utente) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UtenteEntity> create(@RequestBody UtenteEntity utente) {
        return ResponseEntity.ok(utenteService.create(utente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtenteEntity> update(@PathVariable Long id, @RequestBody UtenteEntity utente) {
        UtenteEntity updated = utenteService.update(id, utente);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        utenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/classifica")
    public List<UtenteEntity> getClassificaGenerale() {
        return utenteService.getClassificaGenerale();
    }
}
