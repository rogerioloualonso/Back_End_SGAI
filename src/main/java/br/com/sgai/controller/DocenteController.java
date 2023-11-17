package br.com.sgai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgai.domain.Docente;
import br.com.sgai.dto.DocenteDTO;
import br.com.sgai.service.DocenteService;

@RestController
@RequestMapping(value = "/docente")
public class DocenteController {
    
    @Autowired
    DocenteService docenteService;

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<DocenteDTO> getDocente(@PathVariable String cpf) {
        Docente docente = docenteService.findAllByCpf(cpf);
        DocenteDTO dto =  new DocenteDTO(docente);
		return ResponseEntity.ok().body(dto);
    }
    
}
