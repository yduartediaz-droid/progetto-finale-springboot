package com.awy.progettofinalespringboot.features.risposta;

import com.awy.progettofinalespringboot.features.domanda.DomandaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RispostaRepository extends JpaRepository<RispostaEntity, Long> {

    List<RispostaEntity> findByDomanda(DomandaEntity domanda);

    List<RispostaEntity> findByDomandaIdDomandaPk(Long idDomandaPk);

    List<RispostaEntity> findByDomandaAndCorretta(DomandaEntity domanda, boolean corretta);
}
