package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.difficolta.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.materia.MateriaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DomandaService {

    private final DomandaRepository domandaRepository;

    public List<DomandaResponseDTO> getAll() {
        return domandaRepository.findAll()
                .stream()
                .map(DomandaMapper::toDTO)
                .collect(Collectors.toList()); // LISTA MUTABILE
    }

    public DomandaResponseDTO getById(Long id) {
        return domandaRepository.findById(id)
                .map(DomandaMapper::toDTO)
                .orElse(null);
    }

    public DomandaResponseDTO create(DomandaEntity domanda) {
        DomandaEntity saved = domandaRepository.save(domanda);
        return DomandaMapper.toDTO(saved);
    }

    public DomandaResponseDTO update(Long id, DomandaEntity dati) {
        return domandaRepository.findById(id)
                .map(existing -> {
                    existing.setTesto(dati.getTesto());
                    existing.setMateria(dati.getMateria());
                    existing.setDifficolta(dati.getDifficolta());
                    existing.setCuriosita(dati.getCuriosita());
                    DomandaEntity saved = domandaRepository.save(existing);
                    return DomandaMapper.toDTO(saved);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        if (domandaRepository.existsById(id)) {
            domandaRepository.deleteById(id);
        }
    }

    public List<DomandaResponseDTO> getByMateria(MateriaEnum materia) {
        return domandaRepository.findByMateria(materia)
                .stream()
                .map(DomandaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<DomandaResponseDTO> getByDifficolta(DifficoltaEnum difficolta) {
        return domandaRepository.findByDifficolta(difficolta)
                .stream()
                .map(DomandaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<DomandaResponseDTO> getByMateriaAndDifficolta(MateriaEnum materia, DifficoltaEnum difficolta) {
        return domandaRepository.findByMateriaAndDifficolta(materia, difficolta)
                .stream()
                .map(DomandaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<DomandaResponseDTO> getRandomDomande(int count) {
        List<DomandaResponseDTO> tutte = new ArrayList<>(getAll());
        if (tutte.isEmpty()) return List.of();
        Collections.shuffle(tutte);
        return tutte.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
