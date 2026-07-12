package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.materia.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.materia.MateriaEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DomandaRepository extends JpaRepository<DomandaEntity, Long> {
    List<DomandaEntity> findByMateria(MateriaEnum materia);
    List<DomandaEntity> findByDifficolta(DifficoltaEnum difficolta);
    List<DomandaEntity> findByMateriaAndDifficolta(MateriaEnum materia, DifficoltaEnum difficolta);
}

