package com.poo.trab1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SALARIO")
    private Double salario;

    @Column(name = "DT_ADMISSAO")
    private LocalDate dtAdmissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTAMENTO")
    private Departamento departamento;

    @Column(name = "DTYPE", insertable = false, updatable = false)
    private String dtype;

    public void aumentaSalario() {
        this.setSalario(this.getSalario() + this.getSalario() * 0.10);
    }

}
