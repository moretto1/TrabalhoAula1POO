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
        return ResponseEntity.ok(this.funcionarioService.create(funcionarioDtoList));
    }

    @PatchMapping(value = "/departamento/{idDepartamento}")
    public ResponseEntity<?> aumentaSalario(@PathVariable Long idDepartamento) {
        if(funcionarioService.aumentaSalario(idDepartamento)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }


}
