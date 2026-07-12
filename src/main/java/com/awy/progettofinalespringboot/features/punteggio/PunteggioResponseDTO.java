package com.awy.progettofinalespringboot.features.punteggio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PunteggioResponseDTO {
    private Long idPunteggio;
    private Long idUtente;
    private String livello;
    private int punteggioFinale;
    private int risposteCorrette;
    private int totaleDomande;
    private String dataQuiz;
}
