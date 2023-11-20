package br.com.sgai.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sgai.domain.Ambiente;
import br.com.sgai.domain.Evento;
import br.com.sgai.dto.AmbienteDTO;
import br.com.sgai.dto.AmbienteNewDTO;
import br.com.sgai.service.AmbienteService;

@RestController
@RequestMapping(value = "/ambiente")
public class AmbienteController {
    
    @Autowired
    AmbienteService service;
    
    @PostMapping
	public ResponseEntity<Void> insert(@Validated @RequestBody AmbienteNewDTO objDTO) {
    	
		Ambiente ambiente = new Ambiente(objDTO.getNome(), objDTO.getDescricao(), objDTO.getCapacidade(),
				objDTO.getTipo(),objDTO.getSituacao(), LocalDateTime.now());
		
		Ambiente obj = service.insert(ambiente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

    @GetMapping(value = "/all")
    public ResponseEntity<List<AmbienteDTO>> find() {
        List<Ambiente> list = service.findAll();
        List<AmbienteDTO> listDTO = list.stream().map(obj -> new AmbienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    
    @GetMapping(value = "/byID/{id}")
    public ResponseEntity<AmbienteDTO> getAmbienteById(@PathVariable int id) {
        Ambiente ambiente = service.findById(id);
        AmbienteDTO dto =  new AmbienteDTO(ambiente);
		return ResponseEntity.ok().body(dto);
    }
    
    @DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
    	service.delete(id);
		return ResponseEntity.noContent().build();
	}
    
    @PostMapping(value = "/atualizar")
	public Boolean atualizar(@Validated @RequestBody AmbienteNewDTO objDTO) {
    	
    	Ambiente aux = service.findById(objDTO.getId());
    	List<Evento> eventos =  aux.getEventos();
    	
    	Ambiente ambiente = new Ambiente(objDTO.getId() ,objDTO.getNome(), objDTO.getDescricao(), objDTO.getCapacidade(),
    			objDTO.getTipo(), objDTO.getSituacao(), objDTO.getCreatedAt(), LocalDateTime.now(), eventos);
	
    	service.atualizar(ambiente);
		return true;
	}
}
