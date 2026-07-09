package com.awy.progettofinalespringboot.features.utente;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UtenteRepository extends JpaRepository<UtenteEntity, Long> {

    List<UtenteEntity> findAllByOrderByPuntiTotaliDesc();
}
