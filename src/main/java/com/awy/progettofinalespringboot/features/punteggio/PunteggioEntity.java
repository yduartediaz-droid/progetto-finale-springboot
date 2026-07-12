package com.awy.progettofinalespringboot.features.punteggio;

import com.awy.progettofinalespringboot.features.difficolta.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.utente.UtenteEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_punteggi")
public class PunteggioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPunteggioPk;

    @ManyToOne
    @JoinColumn(name = "id_utente_fk", nullable = false)
    private UtenteEntity utente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficoltaEnum livello;

    @Column(nullable = false)
    private int punteggioFinale;

    @Column(nullable = false)
    private int risposteCorrette;

    @Column(nullable = false)
    private int totaleDomande;

    @Column(nullable = false)
    private LocalDateTime dataQuiz;
}
