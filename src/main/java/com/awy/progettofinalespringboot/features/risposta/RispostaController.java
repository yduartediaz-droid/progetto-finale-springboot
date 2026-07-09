package com.awy.progettofinalespringboot.features.risposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risposte")
public class RispostaController {

    @Autowired
    private RispostaService rispostaService;

    @GetMapping
    public List<RispostaEntity> getAll() {
        return rispostaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RispostaEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rispostaService.getById(id));
    }

    @GetMapping("/domanda/{idDomanda}")
    public List<RispostaEntity> getByDomanda(@PathVariable Long idDomanda) {
        return rispostaService.getByDomanda(idDomanda);
    }

    @PostMapping
    public ResponseEntity<RispostaEntity> create(@RequestBody RispostaEntity risposta) {
        RispostaEntity salvata = rispostaService.create(risposta);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RispostaEntity> update(@PathVariable Long id, @RequestBody RispostaEntity datiAggiornati) {
        return ResponseEntity.ok(rispostaService.update(id, datiAggiornati));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rispostaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}