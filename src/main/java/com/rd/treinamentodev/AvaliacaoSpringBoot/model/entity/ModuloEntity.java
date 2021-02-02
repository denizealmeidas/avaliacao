package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "TB_MODULO")
@Data
public class ModuloEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODULO")
    private BigInteger idModulo;

    @Column(name = "DS_NOME")
    private String dsNome;

    @ManyToOne
    @JoinColumn(name = "ID_INSTRUTOR")
    private InstrutorEntity idInstrutor;

}
