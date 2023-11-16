package br.com.sgai.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgai.domain.Ambiente;
import br.com.sgai.dto.AmbienteDTO;
import br.com.sgai.service.AmbienteService;

@RestController
@RequestMapping(value = "/ambiente")
public class AmbienteController {
    
    @Autowired
    AmbienteService service;

    @GetMapping(value = "/findAllById/{id}")
    public ResponseEntity<List<AmbienteDTO>> find(@PathVariable Integer id) {
        List<Ambiente> list = service.findAllById(id);
        List<AmbienteDTO> listDTO = list.stream().map(obj -> new AmbienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}