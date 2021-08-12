package com.poo.trab1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Gerente extends Funcionario {

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getNome() {
        return super.getNome() + " | GERENTE";
    }

    @Override
    public Double getSalario() {
        return super.getSalario();
    }

    @Override
    public LocalDate getDtAdmissao() {
        return super.getDtAdmissao();
    }

    @Override
    public Empresa getEmpresa() {
        return super.getEmpresa();
    }

    @Override
    public Departamento getDepartamento() {
        return super.getDepartamento();
    }

    @Override
    public void aumentaSalario() {
        this.setSalario(this.getSalario() + this.getSalario() * 0.15);
    }

}
