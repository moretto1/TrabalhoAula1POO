package com.poo.trab1.factory;

import com.poo.trab1.dto.DepartamentoDto;
import com.poo.trab1.entity.Departamento;

public class DepartamentoFacotry {

    public static Departamento buildEntityFromDto(DepartamentoDto departamentoDto) {
        return Departamento.builder()
                .id(departamentoDto.getId())
                .nome(departamentoDto.getNome())
                .build();
    }

    public static DepartamentoDto buildDtoFromEntity(Departamento departamento) {
        return DepartamentoDto.builder()
                .id(departamento.getId())
                .nome(departamento.getNome())
                .build();
    }

}
