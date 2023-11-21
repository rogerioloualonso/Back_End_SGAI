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

import br.com.sgai.domain.Docente;
import br.com.sgai.domain.Turma;
import br.com.sgai.dto.DocenteDTO;
import br.com.sgai.dto.DocenteNewDTO;
import br.com.sgai.service.DocenteService;

@RestController
@RequestMapping(value = "/docente")
public class DocenteController {
    
    @Autowired
    DocenteService docenteService;
    
    @PostMapping
	public ResponseEntity<Void> insert(@Validated @RequestBody DocenteNewDTO objDTO) {
    	
    	Docente docente = new Docente(objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone(),
    			objDTO.getMatricula(), objDTO.getSenha(), LocalDateTime.now());
		
    	Docente obj = docenteService.insert(docente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<DocenteDTO> getDocente(@PathVariable String cpf) {
        Docente docente = docenteService.findAllByCpf(cpf);
        DocenteDTO dto =  new DocenteDTO(docente);
		return ResponseEntity.ok().body(dto);
    }
    
    @GetMapping(value = "/byId/{id}")
    public ResponseEntity<DocenteDTO> getDocenteById(@PathVariable int id) {
        Docente docente = docenteService.findById(id);
        DocenteDTO dto =  new DocenteDTO(docente);
		return ResponseEntity.ok().body(dto);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<DocenteDTO>> getAllDocente() {
        List<Docente> docente = docenteService.findAll();
        List<DocenteDTO> listDTO = docente.stream()
                .sorted(Comparator.comparing(Docente::getNome))
                .map(obj -> new DocenteDTO(obj))
                .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
    	docenteService.delete(id);
		return ResponseEntity.noContent().build();
	}
    
    @PostMapping(value = "/atualizar")
	public Boolean atualizar(@Validated @RequestBody DocenteNewDTO objDTO) {
    	
    	Docente aux = docenteService.findById(objDTO.getId());
    	List<Turma> turmas =  aux.getTurma();
    	
    	Docente docente = new Docente(objDTO.getId(), objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone(),
    			objDTO.getMatricula(), objDTO.getSenha(), aux.getCreatedAt(), LocalDateTime.now());
    	
    	docenteService.atualizar(docente);
		return true;
	}
    
}
