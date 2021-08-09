package com.poo.trab1.service.impl;

import com.poo.trab1.dto.EmpresaDto;
import com.poo.trab1.entity.Empresa;
import com.poo.trab1.factory.EmpresaFactory;
import com.poo.trab1.repository.EmpresaRepository;
import com.poo.trab1.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public EmpresaDto create(EmpresaDto empresaDto) {
        Empresa empresa = EmpresaFactory.buildEntityFromDto(empresaDto);
        empresa = empresaRepository.save(empresa);
        return EmpresaFactory.buildDtoFromEntity(empresa);
    }
}
