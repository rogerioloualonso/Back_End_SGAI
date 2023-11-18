package br.com.sgai.controller;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sgai.domain.Evento;
import br.com.sgai.dto.EventoDTO;
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
    
    @PostMapping(value = "/iniciar/{id}")
	public Boolean iniciar(@PathVariable int id) {
		service.iniciar(id);
		return true;
	}
    
    @PostMapping(value = "/finalizar/{id}")
	public Boolean finalizar(@PathVariable int id) {
		service.finalizar(id);
		return true;
	}
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<EventoDTO>> getDocente(@PathVariable int id) {
    	List<Evento> evento = service.findByIdDocente(id);
    	List<EventoDTO> listDTO = evento.stream()
                .sorted(Comparator.comparing(Evento::getDataEvento).reversed())
                .map(obj -> new EventoDTO(obj))
                .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
}
