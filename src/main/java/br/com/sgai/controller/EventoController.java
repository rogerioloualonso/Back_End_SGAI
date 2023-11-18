package br.com.sgai.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sgai.domain.Evento;
import br.com.sgai.dto.EventonewDTO;
import br.com.sgai.service.EventoService;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {
    
    @Autowired
    EventoService service;

    @PostMapping
	public ResponseEntity<Void> insert(@Validated @RequestBody EventonewDTO objDTO) {
    	int idAmbiente = objDTO.getIdAmbiente();
    	int idTurma = objDTO.getIdTurma();
    	
		Evento obj = service.newFromDTO(objDTO);
		obj = service.insert(obj,idAmbiente,idTurma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
