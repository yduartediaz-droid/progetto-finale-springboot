package com.awy.progettofinalespringboot.features.risposta;

import com.awy.progettofinalespringboot.features.domanda.DomandaEntity;
import com.awy.progettofinalespringboot.features.domanda.DomandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RispostaService {

    @Autowired
    private RispostaRepository rispostaRepository;

    @Autowired
    private DomandaRepository domandaRepository;

    public List<RispostaEntity> getAll() {
        return rispostaRepository.findAll();
    }

    public RispostaEntity getById(Long id) {
        return rispostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risposta non trovata con id: " + id));
    }

    public List<RispostaEntity> getByDomanda(Long idDomanda) {
        return rispostaRepository.findByDomandaIdDomandaPk(idDomanda);
    }

    public RispostaEntity create(RispostaEntity risposta) {
        Long idDomanda = risposta.getDomanda().getIdDomandaPk();
        DomandaEntity domanda = domandaRepository.findById(idDomanda)
                .orElseThrow(() -> new RuntimeException("Domanda non trovata con id: " + idDomanda));

        risposta.setDomanda(domanda);
        return rispostaRepository.save(risposta);
    }

    public RispostaEntity update(Long id, RispostaEntity datiAggiornati) {
        RispostaEntity risposta = rispostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risposta non trovata con id: " + id));

        risposta.setTesto(datiAggiornati.getTesto());
        risposta.setCorretta(datiAggiornati.isCorretta());
        return rispostaRepository.save(risposta);
    }

    public void delete(Long id) {
        if (!rispostaRepository.existsById(id)) {
            throw new RuntimeException("Risposta non trovata con id: " + id);
        }
        rispostaRepository.deleteById(id);
    }
}