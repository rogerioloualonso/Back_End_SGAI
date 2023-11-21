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
import br.com.sgai.domain.Presenca;
import br.com.sgai.domain.Turma;
import br.com.sgai.dto.DiscenteDTO;
import br.com.sgai.dto.DiscenteNewDTO;
import br.com.sgai.dto.DocenteDTO;
import br.com.sgai.dto.DocenteNewDTO;
import br.com.sgai.service.DiscenteService;
import br.com.sgai.service.TurmaService;

@RestController
@RequestMapping(value = "/discente")
public class DiscenteController {
    
    @Autowired
    DiscenteService discenteService;
    
    @Autowired
    TurmaService turmaService;
    
    @PostMapping
	public ResponseEntity<Void> insert(@Validated @RequestBody DiscenteNewDTO objDTO) {
    	
    	Discente discente = new Discente(objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone(),
    			objDTO.getMatricula(), objDTO.getSenha(), LocalDateTime.now());
		
    	Discente obj = discenteService.insert(discente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


    @GetMapping(value = "/{cpf}")
    public ResponseEntity<DiscenteDTO> getDocente(@PathVariable String cpf) {
        Discente discente = discenteService.findAllByCpf(cpf);
        DiscenteDTO dto =  new DiscenteDTO(discente);
		return ResponseEntity.ok().body(dto);
    }
    
    @GetMapping(value = "/byId/{id}")
    public ResponseEntity<DiscenteDTO> getDocenteById(@PathVariable int id) {
        Discente discente = discenteService.findAllById(id);
        DiscenteDTO dto =  new DiscenteDTO(discente);
		return ResponseEntity.ok().body(dto);
    }
    
    @GetMapping(value = "/byTurma/{id}")
    public ResponseEntity<List<DiscenteDTO>> getDocenteByTurma(@PathVariable int id) {
        Turma turma = turmaService.findById(id);
        List<Discente> discente = turma.getDiscentes();
        List<DiscenteDTO> listDTO = discente.stream()
                .sorted(Comparator.comparing(Discente::getNome))
                .map(obj -> new DiscenteDTO(obj))
                .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<DiscenteDTO>> getAllDiscente() {
        List<Discente> docente = discenteService.findAll();
        List<DiscenteDTO> listDTO = docente.stream()
                .sorted(Comparator.comparing(Discente::getNome))
                .map(obj -> new DiscenteDTO(obj))
                .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
    	discenteService.delete(id);
		return ResponseEntity.noContent().build();
	}
    
    @PostMapping(value = "/atualizar")
	public Boolean atualizar(@Validated @RequestBody DiscenteNewDTO objDTO) {
    	
    	Discente aux = discenteService.findAllById(objDTO.getId());
    	List<Turma> turmas =  aux.getTurmas();
    	List<Presenca> presencas = aux.getPresenca();
    	
    	Discente discente = new Discente(objDTO.getId(), objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone(),
    			objDTO.getMatricula(), objDTO.getSenha(), aux.getCreatedAt(), LocalDateTime.now(), presencas, turmas);
    	
    	discenteService.atualizar(discente);
		return true;
	}
    
}
