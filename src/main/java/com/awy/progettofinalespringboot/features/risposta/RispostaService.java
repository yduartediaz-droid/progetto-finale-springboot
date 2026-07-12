package com.awy.progettofinalespringboot.features.risposta;

import com.awy.progettofinalespringboot.features.domanda.DomandaEntity;
import com.awy.progettofinalespringboot.features.domanda.DomandaRepository;
import com.awy.progettofinalespringboot.features.risposta.RispostaResponseDTO;
import com.awy.progettofinalespringboot.features.risposta.RispostaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RispostaService {

    private final RispostaRepository rispostaRepository;
    private final DomandaRepository domandaRepository;

    public List<RispostaResponseDTO> getAll() {
        return rispostaRepository.findAll()
                .stream()
                .map(RispostaMapper::toDTO)
                .toList();
    }

    public RispostaResponseDTO getById(Long id) {
        RispostaEntity risposta = rispostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risposta non trovata con id: " + id));

        return RispostaMapper.toDTO(risposta);
    }

    public List<RispostaResponseDTO> getByDomanda(Long idDomanda) {
        return rispostaRepository.findByDomandaIdDomandaPk(idDomanda)
                .stream()
                .map(RispostaMapper::toDTO)
                .toList();
    }

    public RispostaResponseDTO create(RispostaEntity risposta) {

        Long idDomanda = risposta.getDomanda().getIdDomandaPk();

        DomandaEntity domanda = domandaRepository.findById(idDomanda)
                .orElseThrow(() -> new RuntimeException("Domanda non trovata con id: " + idDomanda));

        risposta.setDomanda(domanda);

        RispostaEntity saved = rispostaRepository.save(risposta);
        return RispostaMapper.toDTO(saved);
    }

    public RispostaResponseDTO update(Long id, RispostaEntity datiAggiornati) {

        RispostaEntity risposta = rispostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risposta non trovata con id: " + id));

        risposta.setTesto(datiAggiornati.getTesto());
        risposta.setCorretta(datiAggiornati.isCorretta());

        RispostaEntity saved = rispostaRepository.save(risposta);
        return RispostaMapper.toDTO(saved);
    }

    public void delete(Long id) {
        if (!rispostaRepository.existsById(id)) {
            throw new RuntimeException("Risposta non trovata con id: " + id);
        }
        rispostaRepository.deleteById(id);
    }
}
