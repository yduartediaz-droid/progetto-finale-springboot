package com.awy.progettofinalespringboot.features.utente;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public List<UtenteEntity> getAll() {
        return utenteRepository.findAll();
    }

    public UtenteEntity getById(Long id) {
        return utenteRepository.findById(id)
                .orElse(null);
    }

    public UtenteEntity create(UtenteEntity utente) {
        return utenteRepository.save(utente);
    }

    public UtenteEntity update(Long id, UtenteEntity updated) {
        UtenteEntity existing = getById(id);
        if (existing == null) return null;

        existing.setUsername(updated.getUsername());
        existing.setPuntiTotali(updated.getPuntiTotali());

        return utenteRepository.save(existing);
    }

    public void delete(Long id) {
        utenteRepository.deleteById(id);
    }

    // Classifica generale
    public List<UtenteEntity> getClassificaGenerale() {
        return utenteRepository.findAllByOrderByPuntiTotaliDesc();
    }
}
