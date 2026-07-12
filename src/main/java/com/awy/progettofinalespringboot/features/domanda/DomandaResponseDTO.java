package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.risposta.RispostaResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DomandaResponseDTO {
    private Long idDomanda;
    private String testo;
    private String materia;
    private String difficolta;
    private String curiosita;
    private List<RispostaResponseDTO> risposte;
}
