package com.poo.trab1.service.impl;

import com.poo.trab1.dto.DepartamentoDto;
import com.poo.trab1.factory.DepartamentoFactory;
import com.poo.trab1.repository.DepartamentoRepository;
import com.poo.trab1.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<DepartamentoDto> getAllDepartamentos() {
        return departamentoRepository.findAll().stream()
                .map(DepartamentoFactory::buildDtoFromEntity)
                .collect(Collectors.toList());
    }

}
