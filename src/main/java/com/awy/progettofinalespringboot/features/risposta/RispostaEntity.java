package com.awy.progettofinalespringboot.features.risposta;

import com.awy.progettofinalespringboot.features.domanda.DomandaEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_risposte")
public class RispostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_risposta_pk")
    private Long idRispostaPk;

    @Column(nullable = false)
    private String testo;

    @Column(nullable = false)
    private boolean corretta;

    @ManyToOne
    @JoinColumn(name = "id_domanda_fk", nullable = false)
    @JsonBackReference
    private DomandaEntity domanda;
}
