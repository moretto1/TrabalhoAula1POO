package com.poo.trab1.repository;

import com.poo.trab1.entity.Departamento;
import com.poo.trab1.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findAllByDepartamento(Departamento departamento);

}
