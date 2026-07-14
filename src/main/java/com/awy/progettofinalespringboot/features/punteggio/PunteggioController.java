package com.awy.progettofinalespringboot.features.punteggio;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/punteggi")
@RequiredArgsConstructor
public class PunteggioController {

    private final PunteggioService punteggioService;

    @PostMapping
    public PunteggioResponseDTO salva(@RequestBody PunteggioRequestDTO dto) {
        return punteggioService.salvaPunteggio(dto);
    }

    // 🔥 CLASSIFICA PER LIVELLO (FACILE / MEDIO / DIFFICILE)
    @GetMapping("/classifica/{livello}")
    public List<PunteggioResponseDTO> getClassificaPerLivello(@PathVariable String livello) {
        return punteggioService.getClassificaPerLivello(livello);
    }

    // 🔥 CLASSIFICA COMPLETA (opzionale)
    @GetMapping("/classifica")
    public List<PunteggioResponseDTO> getClassificaCompleta() {
        return punteggioService.getClassificaCompleta();
    }
}
