package com.awy.progettofinalespringboot.features.punteggio;

import com.awy.progettofinalespringboot.features.punteggio.PunteggioRequestDTO;
import com.awy.progettofinalespringboot.features.punteggio.PunteggioResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/punteggi")
@RequiredArgsConstructor
public class PunteggioController {

    private final PunteggioService punteggioService;

    @PostMapping
    public PunteggioResponseDTO salva(@RequestBody PunteggioRequestDTO dto) {
        return punteggioService.salvaPunteggio(dto);
    }

}
