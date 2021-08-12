package com.poo.trab1.factory;

import com.poo.trab1.dto.FuncionarioDto;
import com.poo.trab1.entity.Analista;
import com.poo.trab1.entity.Funcionario;
import com.poo.trab1.entity.Gerente;
import com.poo.trab1.entity.Tecnico;

import java.time.LocalDate;

public class FuncionarioFactory {

    public static Gerente buildGerenteEntityFromDto(FuncionarioDto funcionarioDto) {
        Gerente gerente = new Gerente();
        gerente.setId(funcionarioDto.getId());
        gerente.setNome(funcionarioDto.getNome());
        gerente.setSalario(funcionarioDto.getSalario());
        gerente.setDtAdmissao(LocalDate.now());
        gerente.setEmpresa(EmpresaFactory.buildEntityFromDto(funcionarioDto.getEmpresa()));
        gerente.setDepartamento(DepartamentoFactory.buildEntityFromDto(funcionarioDto.getDepartamento()));
        return gerente;
    }

    public static Tecnico buildTecnicoEntityFromDto(FuncionarioDto funcionarioDto) {
        Tecnico tecnico = new Tecnico();
        tecnico.setId(funcionarioDto.getId());
        tecnico.setNome(funcionarioDto.getNome());
        tecnico.setSalario(funcionarioDto.getSalario());
        tecnico.setDtAdmissao(LocalDate.now());
        tecnico.setEmpresa(EmpresaFactory.buildEntityFromDto(funcionarioDto.getEmpresa()));
        tecnico.setDepartamento(DepartamentoFactory.buildEntityFromDto(funcionarioDto.getDepartamento()));
        return tecnico;
    }

    public static Analista buildAnalistaEntityFromDto(FuncionarioDto funcionarioDto) {
        Analista analista = new Analista();
        analista.setId(funcionarioDto.getId());
        analista.setNome(funcionarioDto.getNome());
        analista.setSalario(funcionarioDto.getSalario());
        analista.setDtAdmissao(LocalDate.now());
        analista.setEmpresa(EmpresaFactory.buildEntityFromDto(funcionarioDto.getEmpresa()));
        analista.setDepartamento(DepartamentoFactory.buildEntityFromDto(funcionarioDto.getDepartamento()));
        return analista;
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
