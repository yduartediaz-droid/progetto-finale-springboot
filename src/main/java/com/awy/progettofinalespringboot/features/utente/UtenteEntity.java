package com.awy.progettofinalespringboot.features.utente;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_utenti")
public class UtenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtentePk;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false)
    private int puntiTotali;
}
