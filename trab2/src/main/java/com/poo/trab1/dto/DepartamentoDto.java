package com.poo.trab1.dto;

import com.poo.trab1.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoDto {

    private Long id;
    private String nome;
    private List<Funcionario> funcionarios;

}
