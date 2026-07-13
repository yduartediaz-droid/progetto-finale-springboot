package com.awy.progettofinalespringboot.features.utente;

import com.awy.progettofinalespringboot.features.utente.UtenteEntity;
import com.awy.progettofinalespringboot.features.utente.UtenteResponseDTO;

public class UtenteMapper {

    public static UtenteResponseDTO toDTO(UtenteEntity entity) {
        return UtenteResponseDTO.builder()
                .idUtente(entity.getIdUtentePk())
                .username(entity.getUsername())
                .build();
    }
}
