package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.difficolta.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.materia.MateriaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/domande")
public class DomandaController {

    private final DomandaService domandaService;

    @GetMapping
    public List<DomandaResponseDTO> getAll() {
        return domandaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomandaResponseDTO> getById(@PathVariable Long id) {
        DomandaResponseDTO dto = domandaService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DomandaResponseDTO> create(@RequestBody DomandaEntity domanda) {
        return ResponseEntity.ok(domandaService.create(domanda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DomandaResponseDTO> update(@PathVariable Long id, @RequestBody DomandaEntity domanda) {
        DomandaResponseDTO updated = domandaService.update(id, domanda);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        domandaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/materia/{materia}")
    public List<DomandaResponseDTO> getByMateria(@PathVariable MateriaEnum materia) {
        return domandaService.getByMateria(materia);
    }

    @GetMapping("/difficolta/{difficolta}")
    public List<DomandaResponseDTO> getByDifficolta(@PathVariable DifficoltaEnum difficolta) {
        return domandaService.getByDifficolta(difficolta);
    }

    @GetMapping("/filter")
    public List<DomandaResponseDTO> getByMateriaAndDifficolta(
            @RequestParam MateriaEnum materia,
            @RequestParam DifficoltaEnum difficolta) {
        return domandaService.getByMateriaAndDifficolta(materia, difficolta);
    }

    @GetMapping("/next")
    public ResponseEntity<List<DomandaResponseDTO>> getRandomDomande(@RequestParam int count) {
        return ResponseEntity.ok(domandaService.getRandomDomande(count));
    }

    @GetMapping("/livello/{livello}")
    public ResponseEntity<List<DomandaResponseDTO>> getDomandeByLivello(@PathVariable String livello) {

        int count;

        switch (livello.toUpperCase()) {
            case "FACILE": count = 10; break;
            case "MEDIO": count = 15; break;
            case "DIFFICILE": count = 25; break;
            default: return ResponseEntity.badRequest().build();
        }

        List<DomandaResponseDTO> tutte = new ArrayList<>(domandaService.getAll());
        Collections.shuffle(tutte);

        List<DomandaResponseDTO> selezionate = tutte.stream()
                .limit(count)
                .collect(Collectors.toList());

        return ResponseEntity.ok(selezionate);
    }

}
