package com.poo.trab1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;

}
