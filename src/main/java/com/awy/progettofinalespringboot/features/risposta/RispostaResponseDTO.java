package com.awy.progettofinalespringboot.features.risposta;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RispostaResponseDTO {
    private Long idRisposta;
    private String testo;
    private boolean corretta;
}
