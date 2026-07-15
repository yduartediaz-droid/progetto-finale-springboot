package com.awy.progettofinalespringboot.features.punteggio;

public class PunteggioMapper {

    public static PunteggioResponseDTO toDTO(PunteggioEntity entity) {
        return PunteggioResponseDTO.builder()
                .idPunteggio(entity.getIdPunteggioPk())
                .idUtente(entity.getUtente().getIdUtentePk())
                .username(entity.getUtente().getUsername())   // 🔥 AGGIUNTO
                .livello(entity.getLivello().name())
                .punteggioFinale(entity.getPunteggioFinale())
                .risposteCorrette(entity.getRisposteCorrette())
                .totaleDomande(entity.getTotaleDomande())
                .dataQuiz(entity.getDataQuiz().toString())
                .build();
    }
}
