package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.materia.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.materia.MateriaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/domande")
public class DomandaController {

    private final DomandaService domandaService;

    @GetMapping
    public List<DomandaEntity> getAll() {
        return domandaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomandaEntity> getById(@PathVariable Long id) {
        DomandaEntity domanda = domandaService.getById(id);
        return domanda != null ? ResponseEntity.ok(domanda) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DomandaEntity> create(@RequestBody DomandaEntity domanda) {
        return ResponseEntity.ok(domandaService.create(domanda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DomandaEntity> update(@PathVariable Long id, @RequestBody DomandaEntity domanda) {
        DomandaEntity updated = domandaService.update(id, domanda);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        domandaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/materia/{materia}")
    public List<DomandaEntity> getByMateria(@PathVariable MateriaEnum materia) {
        return domandaService.getByMateria(materia);
    }

    @GetMapping("/difficolta/{difficolta}")
    public List<DomandaEntity> getByDifficolta(@PathVariable DifficoltaEnum difficolta) {
        return domandaService.getByDifficolta(difficolta);
    }

    @GetMapping("/filter")
    public List<DomandaEntity> getByMateriaAndDifficolta(
            @RequestParam MateriaEnum materia,
            @RequestParam DifficoltaEnum difficolta) {
        return domandaService.getByMateriaAndDifficolta(materia, difficolta);
    }
}
