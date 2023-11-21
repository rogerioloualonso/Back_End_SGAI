package br.com.sgai.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Comparator;
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

import br.com.sgai.domain.Discente;
import br.com.sgai.domain.Docente;
import br.com.sgai.domain.Evento;
import br.com.sgai.domain.Turma;
import br.com.sgai.dto.TurmaDTO;
import br.com.sgai.dto.TurmaNewDTO;
import br.com.sgai.service.DiscenteService;
import br.com.sgai.service.DocenteService;
import br.com.sgai.service.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
    
    @Autowired
    TurmaService turmaService;
    
    @Autowired
    DiscenteService discenteService;
    
    @Autowired
    DocenteService docenteService;
    
    @PostMapping
	public ResponseEntity<Void> insert(@Validated @RequestBody TurmaNewDTO objDTO) {
    	
    	Docente docente = docenteService.findById(objDTO.getIdDocente());
    	
    	Turma turma = new Turma(objDTO.getId(), docente, objDTO.getTurno(), "Ativa", objDTO.getNome(),
    			LocalDateTime.now(), null, null, null);
		
    	Turma obj = turmaService.insert(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

    @GetMapping(value = "/byDocente/{id}")
    public ResponseEntity<List<TurmaDTO>> getTurmasByIdDocente(@PathVariable int id) {
        List<Turma> turma = turmaService.findAllByIdDocente(id);
        List<TurmaDTO> listDTO = turma.stream().map(obj -> new TurmaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @GetMapping(value = "/byDiscente/{id}")
    public ResponseEntity<List<TurmaDTO>> getTurmasByIdDiscente(@PathVariable int id) {
    	Discente discente = discenteService.findAllById(id);
        List<Turma> turma = discente.getTurmas();
        List<TurmaDTO> listDTO = turma.stream().map(obj -> new TurmaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<TurmaDTO>> getAllTurmas() {
        List<Turma> turma = turmaService.findAll();
        List<TurmaDTO> listDTO = turma.stream()
                .sorted(Comparator.comparing(Turma::getNome))
                .map(obj -> new TurmaDTO(obj))
                .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @GetMapping(value = "/byId/{id}")
    public ResponseEntity<TurmaDTO> getTurmaById(@PathVariable int id) {
        Turma turma = turmaService.findById(id);
        TurmaDTO dto =  new TurmaDTO(turma);
		return ResponseEntity.ok().body(dto);
    }
    
    @DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
    	turmaService.delete(id);
		return ResponseEntity.noContent().build();
	}
    
    @PostMapping(value = "/atualizar")
	public Boolean atualizar(@Validated @RequestBody TurmaNewDTO objDTO) {
    	
    	Turma aux = turmaService.findById(objDTO.getId());
    	Docente docente = docenteService.findById(objDTO.getIdDocente());
    	
    	List<Evento> eventos = aux.getEvento();
    	List<Discente> discentes = aux.getDiscentes();
    	
    	Turma turma = new Turma(objDTO.getId(), docente, objDTO.getTurno(), objDTO.getSituacao(), objDTO.getNome(), 
    			LocalDateTime.now(), eventos, discentes);
    	
    	turmaService.atualizar(turma);
		return true;
	}
    
}
