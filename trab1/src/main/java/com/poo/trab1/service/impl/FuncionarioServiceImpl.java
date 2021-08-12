package com.poo.trab1.service.impl;

import com.poo.trab1.dto.FuncionarioDto;
import com.poo.trab1.entity.Departamento;
import com.poo.trab1.entity.Empresa;
import com.poo.trab1.entity.Funcionario;
import com.poo.trab1.factory.FuncionarioFactory;
import com.poo.trab1.repository.DepartamentoRepository;
import com.poo.trab1.repository.EmpresaRepository;
import com.poo.trab1.repository.FuncionarioRepository;
import com.poo.trab1.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public void create(List<FuncionarioDto> funcionarioDtoList) {
        try {
            var funcionarios = funcionarioDtoList.stream()
                    .map(FuncionarioFactory::buildEntityFromDto)
                    .peek(funcionario -> funcionario.setDtAdmissao(LocalDate.now()))
                    .collect(Collectors.toList());
            funcionarios = funcionarioRepository.saveAll(funcionarios);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Valide se a empresa ou departamento são validos!"
            );
        }
    }

    @Override
    public boolean aumentaSalario(Long idEmpresa, Long idDepartamento) {
        Optional<Empresa> empresaOpt = empresaRepository.findById(idEmpresa);
        if(empresaOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa não encontrado");
        }

        Optional<Departamento> departamentoOpt = departamentoRepository.findById(idDepartamento);
        if(departamentoOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departamento não encontrado");
        }

        List<Funcionario> funcionarioList = funcionarioRepository.findAllByDepartamento(departamentoOpt.get());
         funcionarioList.forEach(funcionario ->
                 funcionario.setSalario(funcionario.getSalario() + funcionario.getSalario() * 0.10)
         );
         funcionarioRepository.saveAll(funcionarioList);
        return true;
    }

}
