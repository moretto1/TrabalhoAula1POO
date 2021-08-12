package com.poo.trab1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poo.trab1.entity.Departamento;
import com.poo.trab1.entity.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuncionarioDto {

    private Long id;

    @NotBlank(message = "É obrigatório informar o nome do funcionário")
    private String nome;

    @NotNull(message = "É obrigatório informar o salário do funcionário")
    @Positive(message = "Salário deve ser maior que zero")
    private Double salario;

    private LocalDate dtAdmissao;

    @NotNull(message = "É necessário informar a empresa do funcionário")
    private EmpresaDto empresa;

    @NotNull(message = "É necessário informar o departamento do funcionário")
    private DepartamentoDto departamento;

    private String cargo;

}
