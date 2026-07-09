package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.materia.DifficoltaEnum;
import com.awy.progettofinalespringboot.features.materia.MateriaEnum;
import com.awy.progettofinalespringboot.features.risposta.RispostaEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_domande")
public class DomandaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domanda_pk")
    private Long idDomandaPk;

    @Column(nullable = false)
    private String testo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MateriaEnum materia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficoltaEnum difficolta;

    @Column(columnDefinition = "TEXT")
    private String curiosita;

    @OneToMany(mappedBy = "domanda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RispostaEntity> risposte;
}
