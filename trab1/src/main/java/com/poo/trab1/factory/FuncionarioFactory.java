package com.poo.trab1.factory;

import com.poo.trab1.dto.FuncionarioDto;
import com.poo.trab1.entity.Funcionario;

public class FuncionarioFactory {

    public static Funcionario buildEntityFromDto(FuncionarioDto funcionarioDto) {
        return Funcionario.builder()
                .id(funcionarioDto.getId())
                .nome(funcionarioDto.getNome())
                .salario(funcionarioDto.getSalario())
                .dtAdmissao(funcionarioDto.getDtAdmissao())
                .empresa(EmpresaFactory.buildEntityFromDto(funcionarioDto.getEmpresa()))
                .departamento(DepartamentoFactory.buildEntityFromDto(funcionarioDto.getDepartamento()))
                .build();
    }

    public static FuncionarioDto buildDtoFromEntity(Funcionario funcionario) {
        return FuncionarioDto.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .salario(funcionario.getSalario())
                .dtAdmissao(funcionario.getDtAdmissao())
                .departamento(DepartamentoFactory.buildDtoFromEntity(funcionario.getDepartamento()))
                .build();
    }

}
