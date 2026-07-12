package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.materia.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.materia.MateriaEnum;
import com.awy.progettofinalespringboot.features.risposta.RispostaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DomandaService {

    private final DomandaRepository domandaRepository;

    // ---------------------------------------------------------
    // GET ALL
    // ---------------------------------------------------------
    public List<DomandaEntity> getAll() {
        return domandaRepository.findAll();
    }

    // ---------------------------------------------------------
    // GET BY ID
    // ---------------------------------------------------------
    public DomandaEntity getById(Long id) {
        return domandaRepository.findById(id).orElse(null);
    }

    // ---------------------------------------------------------
    // CREATE
    // ---------------------------------------------------------
    public DomandaEntity create(DomandaEntity domanda) {

        // Se la lista è null, inizializzala
        if (domanda.getRisposte() == null) {
            domanda.setRisposte(new ArrayList<>());
        }

        // 🔥 Collega ogni risposta alla domanda
        for (RispostaEntity r : domanda.getRisposte()) {
            r.setDomanda(domanda);
        }

        return domandaRepository.save(domanda);
    }

    // ---------------------------------------------------------
    // UPDATE
    // ---------------------------------------------------------
    public DomandaEntity update(Long id, DomandaEntity updated) {
        DomandaEntity existing = getById(id);
        if (existing == null) return null;

        existing.setTesto(updated.getTesto());
        existing.setMateria(updated.getMateria());
        existing.setDifficolta(updated.getDifficolta());
        existing.setCuriosita(updated.getCuriosita());

        // 🔥 Aggiorna correttamente la lista delle risposte
        existing.getRisposte().clear();

        if (updated.getRisposte() != null) {
            for (RispostaEntity r : updated.getRisposte()) {
                r.setDomanda(existing);
                existing.getRisposte().add(r);
            }
        }

        return domandaRepository.save(existing);
    }

    // ---------------------------------------------------------
    // DELETE
    // ---------------------------------------------------------
    public void delete(Long id) {
        domandaRepository.deleteById(id);
    }

    // ---------------------------------------------------------
    // FILTERS
    // ---------------------------------------------------------
    public List<DomandaEntity> getByMateria(MateriaEnum materia) {
        return domandaRepository.findByMateria(materia);
    }

    public List<DomandaEntity> getByDifficolta(DifficoltaEnum difficolta) {
        return domandaRepository.findByDifficolta(difficolta);
    }

    public List<DomandaEntity> getByMateriaAndDifficolta(MateriaEnum materia, DifficoltaEnum difficolta) {
        return domandaRepository.findByMateriaAndDifficolta(materia, difficolta);
    }

    public List<DomandaEntity> getRandomDomande(int count) {
        List<DomandaEntity> tutte = domandaRepository.findAll();

        // Mescola le domande
        Collections.shuffle(tutte);

        // Prendi solo "count" domande
        return tutte.stream()
                .limit(count)
                .toList();
    }


}
