package com.awy.progettofinalespringboot.features.utente;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtenteRepository extends JpaRepository<UtenteEntity, Long> {
    Optional<UtenteEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}
