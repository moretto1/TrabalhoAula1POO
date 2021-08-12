package com.poo.trab1.service;

import com.poo.trab1.dto.FuncionarioDto;

import java.util.List;

public interface FuncionarioService {

    void create(List<FuncionarioDto> funcionarioDtoList);

    boolean aumentaSalario(Long idEmpresa, Long idDepartamento);

}
