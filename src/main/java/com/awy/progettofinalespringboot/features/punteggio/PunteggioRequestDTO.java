package com.awy.progettofinalespringboot.features.punteggio;
import lombok.Data;

@Data
public class PunteggioRequestDTO {
    private Long idUtente;
    private String livello;
    private int punteggioFinale;
    private int risposteCorrette;
    private int totaleDomande;
}
