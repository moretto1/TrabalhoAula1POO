package com.poo.trab1.dto;

import com.poo.trab1.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpresaDto {

    private Long id;

    @NotBlank(message = "É obrigatório informar o nome da empresa")
    private String nome;

    @NotBlank(message = "É obrigatório informar o CNPJ da empresa")
    @Size(max = 14, min = 14, message = "O CNPJ deve conter 14 digitos")
    private String cnpj;

    private List<FuncionarioDto> funcionarios;

}
