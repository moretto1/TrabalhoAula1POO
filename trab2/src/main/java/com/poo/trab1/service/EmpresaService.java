package com.poo.trab1.service;

import com.poo.trab1.dto.EmpresaDto;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    void create(EmpresaDto empresaDto);

    List<EmpresaDto> getAllEmpresas();

    Optional<EmpresaDto> getEmpresaById(Long id);

}
