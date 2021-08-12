package com.poo.trab1.factory;

import com.poo.trab1.dto.EmpresaDto;
import com.poo.trab1.entity.Empresa;

import java.util.stream.Collectors;

public class EmpresaFactory {

    public static Empresa buildEntityFromDto(EmpresaDto empresaDto) {
        return Empresa.builder()
                .id(empresaDto.getId())
                .nome(empresaDto.getNome())
                .cnpj(empresaDto.getCnpj())
                .build();
    }

    public static EmpresaDto buildDtoFromEntity(Empresa empresa) {
        return EmpresaDto.builder()
                .id(empresa.getId())
                .nome(empresa.getNome())
                .cnpj(empresa.getCnpj())
                .funcionarios(
                        empresa.getFuncionarios().stream()
                                .map(FuncionarioFactory::buildDtoFromEntity)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
