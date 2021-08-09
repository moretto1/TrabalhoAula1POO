package com.poo.trab1.resources;

import com.poo.trab1.dto.EmpresaDto;
import com.poo.trab1.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid EmpresaDto empresaDto) {
        return ResponseEntity.ok(empresaService.create(empresaDto));
    }

}
