package com.poo.trab1.resources;

import com.poo.trab1.dto.FuncionarioDto;
import com.poo.trab1.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid List<FuncionarioDto> funcionarioDtoList) {
        this.funcionarioService.create(funcionarioDtoList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(value = "/empresas/{idEmpresa}/departamento/{idDepartamento}")
    public ResponseEntity<?> aumentaSalario(@PathVariable Long idEmpresa, @PathVariable Long idDepartamento) {
        if(funcionarioService.aumentaSalario(idEmpresa, idDepartamento)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }


}
