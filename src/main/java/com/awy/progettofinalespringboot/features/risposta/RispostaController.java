package com.awy.progettofinalespringboot.features.risposta;

import com.awy.progettofinalespringboot.features.risposta.RispostaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risposte")
@RequiredArgsConstructor
public class RispostaController {

    private final RispostaService rispostaService;

    @GetMapping
    public List<RispostaResponseDTO> getAll() {
        return rispostaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RispostaResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rispostaService.getById(id));
    }

    @GetMapping("/domanda/{idDomanda}")
    public List<RispostaResponseDTO> getByDomanda(@PathVariable Long idDomanda) {
        return rispostaService.getByDomanda(idDomanda);
    }

    @PostMapping
    public ResponseEntity<RispostaResponseDTO> create(@RequestBody RispostaEntity risposta) {
        return ResponseEntity.status(201).body(rispostaService.create(risposta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RispostaResponseDTO> update(@PathVariable Long id, @RequestBody RispostaEntity datiAggiornati) {
        return ResponseEntity.ok(rispostaService.update(id, datiAggiornati));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rispostaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
