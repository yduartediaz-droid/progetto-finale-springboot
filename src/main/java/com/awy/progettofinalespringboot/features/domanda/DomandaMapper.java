package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.risposta.RispostaEntity;
import com.awy.progettofinalespringboot.features.risposta.RispostaMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DomandaMapper {

    public static DomandaResponseDTO toDTO(DomandaEntity entity) {

        List<RispostaEntity> risposte = entity.getRisposte();

        return DomandaResponseDTO.builder()
                .idDomanda(entity.getIdDomandaPk())   // CORRETTO
                .testo(entity.getTesto())
                .materia(entity.getMateria().name())
                .difficolta(entity.getDifficolta().name())
                .curiosita(entity.getCuriosita())
                .risposte(
                        risposte == null
                                ? List.of()
                                : risposte.stream()
                                .map(RispostaMapper::toDTO)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
