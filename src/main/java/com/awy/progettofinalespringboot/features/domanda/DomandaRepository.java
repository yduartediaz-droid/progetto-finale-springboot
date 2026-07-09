package com.awy.progettofinalespringboot.features.domanda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomandaRepository extends JpaRepository<DomandaEntity, Long> {
}
