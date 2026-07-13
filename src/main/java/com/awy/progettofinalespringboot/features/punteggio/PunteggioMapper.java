package com.awy.progettofinalespringboot.features.punteggio.mapper;

import com.awy.progettofinalespringboot.features.punteggio.PunteggioEntity;
import com.awy.progettofinalespringboot.features.punteggio.PunteggioResponseDTO;

public class PunteggioMapper {

    public static PunteggioResponseDTO toDTO(PunteggioEntity entity) {
        return PunteggioResponseDTO.builder()
                .idPunteggio(entity.getIdPunteggioPk())
                .idUtente(entity.getUtente().getIdUtentePk())
                .livello(entity.getLivello().name())
                .punteggioFinale(entity.getPunteggioFinale())
                .risposteCorrette(entity.getRisposteCorrette())
                .totaleDomande(entity.getTotaleDomande())
                .dataQuiz(entity.getDataQuiz().toString())
                .build();
    }
}
