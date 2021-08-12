package com.poo.trab1.service.impl;

import com.poo.trab1.dto.EmpresaDto;
import com.poo.trab1.entity.Empresa;
import com.poo.trab1.factory.EmpresaFactory;
import com.poo.trab1.repository.EmpresaRepository;
import com.poo.trab1.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public void create(EmpresaDto empresaDto) {
        Empresa empresa = EmpresaFactory.buildEntityFromDto(empresaDto);
        empresaRepository.save(empresa);
    }

    @Override
    public List<EmpresaDto> getAllEmpresas() {
        return empresaRepository.findAll()
                .stream()
                .map(EmpresaFactory::buildDtoFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmpresaDto> getEmpresaById(Long id) {
        Optional<Empresa> empresaOpt = empresaRepository.findById(id);
        return empresaOpt.map(EmpresaFactory::buildDtoFromEntity);
    }

}
