package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.materia.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.materia.MateriaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomandaService {

    private final DomandaRepository domandaRepository;

    public List<DomandaEntity> getAll() {
        return domandaRepository.findAll();
    }

    public DomandaEntity getById(Long id) {
        return domandaRepository.findById(id).orElse(null);
    }

    public DomandaEntity create(DomandaEntity domanda) {
        return domandaRepository.save(domanda);
    }

    public DomandaEntity update(Long id, DomandaEntity updated) {
        DomandaEntity existing = getById(id);
        if (existing == null) return null;

        existing.setTesto(updated.getTesto());
        existing.setMateria(updated.getMateria());
        existing.setDifficolta(updated.getDifficolta());
        existing.setCuriosita(updated.getCuriosita());
        existing.setRisposte(updated.getRisposte());

        return domandaRepository.save(existing);
    }

    public void delete(Long id) {
        domandaRepository.deleteById(id);
    }

    public List<DomandaEntity> getByMateria(MateriaEnum materia) {
        return domandaRepository.findByMateria(materia);
    }

    public List<DomandaEntity> getByDifficolta(DifficoltaEnum difficolta) {
        return domandaRepository.findByDifficolta(difficolta);
    }

    public List<DomandaEntity> getByMateriaAndDifficolta(MateriaEnum materia, DifficoltaEnum difficolta) {
        return domandaRepository.findByMateriaAndDifficolta(materia, difficolta);
    }
}
