package com.awy.progettofinalespringboot.features.utente;

import com.awy.progettofinalespringboot.features.utente.LoginRequestDTO;
import com.awy.progettofinalespringboot.features.utente.RegisterRequestDTO;
import com.awy.progettofinalespringboot.features.utente.UtenteResponseDTO;
import com.awy.progettofinalespringboot.features.utente.UtenteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteResponseDTO register(RegisterRequestDTO dto) {

        if (utenteRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username già esistente");
        }

        UtenteEntity nuovo = UtenteEntity.builder()
                .username(dto.getUsername())
                .passwordHash(dto.getPassword()) // ⚠️ per ora senza BCrypt
                .dataCreazione(LocalDateTime.now())
                .build();

        utenteRepository.save(nuovo);

        return UtenteMapper.toDTO(nuovo);
    }

    public UtenteResponseDTO login(LoginRequestDTO dto) {

        UtenteEntity utente = utenteRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        if (!utente.getPasswordHash().equals(dto.getPassword())) {
            throw new RuntimeException("Password errata");
        }

        utente.setUltimoAccesso(LocalDateTime.now());
        utenteRepository.save(utente);

        return UtenteMapper.toDTO(utente);
    }
}
