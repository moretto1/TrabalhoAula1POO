package com.poo.trab1.resources;

import com.poo.trab1.dto.EmpresaDto;
import com.poo.trab1.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid EmpresaDto empresaDto) {
        return ResponseEntity.ok(empresaService.create(empresaDto));
    }

    @GetMapping
    public ResponseEntity<?> getAllEmpresas() {
        return ResponseEntity.ok(empresaService.getAllEmpresas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAllEmpresas(@PathVariable Long id) {
        Optional<EmpresaDto> empresaOpt = empresaService.getEmpresaById(id);
        if(empresaOpt.isPresent()) {
            return ResponseEntity.ok(empresaOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
