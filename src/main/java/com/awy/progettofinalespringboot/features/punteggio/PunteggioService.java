package com.awy.progettofinalespringboot.features.punteggio;

import com.awy.progettofinalespringboot.features.difficolta.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.punteggio.mapper.PunteggioMapper;
import com.awy.progettofinalespringboot.features.utente.UtenteEntity;
import com.awy.progettofinalespringboot.features.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PunteggioService {

    private final PunteggioRepository punteggioRepository;
    private final UtenteRepository utenteRepository;

    public PunteggioResponseDTO salvaPunteggio(PunteggioRequestDTO dto) {

        UtenteEntity utente = utenteRepository.findById(dto.getIdUtente())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        PunteggioEntity entity = PunteggioEntity.builder()
                .utente(utente)
                .livello(DifficoltaEnum.valueOf(dto.getLivello()))
                .punteggioFinale(dto.getPunteggioFinale())
                .risposteCorrette(dto.getRisposteCorrette())
                .totaleDomande(dto.getTotaleDomande())
                .dataQuiz(LocalDateTime.now())
                .build();

        punteggioRepository.save(entity);

        return PunteggioMapper.toDTO(entity);
    }

}
