package com.awy.progettofinalespringboot.features.utente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtenteResponseDTO {
    private Long idUtente;
    private String username;
}
