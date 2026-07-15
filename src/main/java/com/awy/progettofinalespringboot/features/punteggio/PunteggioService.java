package com.awy.progettofinalespringboot.features.punteggio;

import com.awy.progettofinalespringboot.features.difficolta.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.punteggio.PunteggioMapper;
import com.awy.progettofinalespringboot.features.utente.UtenteEntity;
import com.awy.progettofinalespringboot.features.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PunteggioService {

    private final PunteggioRepository punteggioRepository;
    private final UtenteRepository utenteRepository;

    // 🔥 SALVATAGGIO PUNTEGGIO
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

    // 🔥 CLASSIFICA PER LIVELLO (FACILE / MEDIO / DIFFICILE)
    public List<PunteggioResponseDTO> getClassificaPerLivello(String livello) {
        return punteggioRepository.findAll().stream()
                .filter(p -> p.getLivello().name().equalsIgnoreCase(livello))
                .sorted(Comparator.comparing(PunteggioEntity::getPunteggioFinale).reversed())
                .map(PunteggioMapper::toDTO)
                .toList();
    }

    // 🔥 CLASSIFICA COMPLETA (opzionale)
    public List<PunteggioResponseDTO> getClassificaCompleta() {
        return punteggioRepository.findAll().stream()
                .sorted(Comparator.comparing(PunteggioEntity::getPunteggioFinale).reversed())
                .map(PunteggioMapper::toDTO)
                .toList();
    }
}
