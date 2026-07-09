package com.awy.progettofinalespringboot.features.materia;

import com.awy.progettofinalespringboot.features.utente.UtenteEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_punteggio_materia")
public class PunteggioMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punteggio_materia_pk")
    private Long idPunteggioMateriaPk;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MateriaEnum materia;

    @Column(nullable = false)
    private int punti;

    @ManyToOne
    @JoinColumn(name = "id_utente_fk", nullable = false)
    private UtenteEntity utente;
}
