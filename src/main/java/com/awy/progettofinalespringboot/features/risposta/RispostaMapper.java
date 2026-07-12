package com.awy.progettofinalespringboot.features.risposta;

import com.awy.progettofinalespringboot.features.risposta.RispostaEntity;
import com.awy.progettofinalespringboot.features.risposta.RispostaResponseDTO;

public class RispostaMapper {

    public static RispostaResponseDTO toDTO(RispostaEntity entity) {
        return RispostaResponseDTO.builder()
                .idRisposta(entity.getIdRispostaPk())
                .testo(entity.getTesto())
                .corretta(entity.isCorretta())
                .build();
    }
}
