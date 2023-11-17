package br.com.sgai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgai.domain.Discente;
import br.com.sgai.dto.DiscenteDTO;
import br.com.sgai.service.DiscenteService;

@RestController
@RequestMapping(value = "/discente")
public class DiscenteController {
    
    @Autowired
    DiscenteService discenteService;

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<DiscenteDTO> getDocente(@PathVariable String cpf) {
        Discente discente = discenteService.findAllByCpf(cpf);
        DiscenteDTO dto =  new DiscenteDTO(discente);
		return ResponseEntity.ok().body(dto);
    }
    
}
