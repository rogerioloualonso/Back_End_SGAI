package br.com.sgai.controller;

import java.net.URI;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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

import br.com.sgai.domain.Avaliacao;
import br.com.sgai.domain.Discente;
import br.com.sgai.domain.Evento;
import br.com.sgai.domain.Presenca;
import br.com.sgai.domain.Turma;
import br.com.sgai.dto.AvaliacaoDTO;
import br.com.sgai.dto.EventoDTO;
import br.com.sgai.dto.EventonewDTO;
import br.com.sgai.dto.MarcarPresencaDTO;
import br.com.sgai.dto.PresencaDiscenteDTO;
import br.com.sgai.service.AvaliacaoService;
import br.com.sgai.service.DiscenteService;
import br.com.sgai.service.EventoService;
import br.com.sgai.service.PresencaService;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {
    
    @Autowired
    EventoService service;
    
    @Autowired
    DiscenteService DiscenteService;
    
    @Autowired
    PresencaService PresencaService;
    
    @Autowired
    EventoService EventoService;
    
    @Autowired
    AvaliacaoService AvaliacaoService;

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
    
    @PostMapping(value = "/aprovar/{id}")
	public Boolean aprovar(@PathVariable int id) {
		service.aprovar(id);
		return true;
	}
    
    @PostMapping(value = "/reprovar/{id}")
	public Boolean reprovar(@PathVariable int id) {
		service.reprovar(id);
		return true;
	}
    
    @GetMapping(value = "/byDocente/{id}")
    public ResponseEntity<List<EventoDTO>> getByDocente(@PathVariable int id) {
    	List<Evento> evento = service.findByIdDocente(id);
    	List<EventoDTO> listDTO = evento.stream()
                .sorted(Comparator.comparing(Evento::getDataEvento).reversed())
                .map(obj -> new EventoDTO(obj))
                .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @GetMapping(value = "/byDiscente/{id}")
    public ResponseEntity<List<PresencaDiscenteDTO>> getByDiscente(@PathVariable int id) {
    	
    	Discente discente = DiscenteService.findAllById(id);
    	Presenca presencaDiscente = new Presenca();
    	
    	List<Turma> turmas = discente.getTurmas();
    	
    	List<Evento> eventos = new ArrayList<Evento>();

    	for (Turma turma : turmas) {
    	    eventos.addAll(turma.getEvento());
    	}
    	
    	List<PresencaDiscenteDTO> listDTO = new ArrayList<>();

    	for (Evento evento : eventos) {
    		List<Presenca> presencas = evento.getPresenca();
    		for (Presenca presenca : presencas) {
    			if(presenca.getDiscente().getId() == discente.getId()) {
    				presencaDiscente = presenca;
    			}
        	}
    	    listDTO.add(new PresencaDiscenteDTO(evento, presencaDiscente));
    	}

		return ResponseEntity.ok().body(listDTO);
    }
    
    @DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
    	service.delete(id);
		return ResponseEntity.noContent().build();
	}
    
    @PostMapping(value = "/entrada/{idEvento}/{idDiscente}")
	public ResponseEntity<Object> entradaDiscente(@PathVariable int idEvento, @PathVariable int idDiscente) {
    	
    	List<Evento> evento = EventoService.findAll(idEvento);
    	Discente discente = DiscenteService.findAllById(idDiscente);
    	
    	LocalTime localTime = LocalTime.now();
        Time time = Time.valueOf(localTime);
        
    	Presenca presenca = new Presenca(discente, evento.get(0), time, "Iniciada", LocalDateTime.now());
    	
    	Presenca obj = PresencaService.insert(presenca);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
    
    @PostMapping(value = "/saida")
	public ResponseEntity<Object> saidaDiscente(@RequestBody MarcarPresencaDTO obj ) {
    	
    	Presenca presenca = PresencaService.findAllById(obj.getIdPresenca());
    	
    	LocalTime localTime = LocalTime.now();
        Time time = Time.valueOf(localTime);
        
    	presenca.setHoraFim(time);
    	presenca.setSituacao("Finalizada");
    	
    	Presenca presencaUpdate = PresencaService.update(presenca);
    	
    	List<Evento> evento = EventoService.findAll(presenca.getEvento().getId());
    	
    	Avaliacao avaliacao = new Avaliacao(evento.get(0), obj.getComentario(), obj.getRating(), LocalDateTime.now());
    	
    	Avaliacao objAvaliacao = AvaliacaoService.insert(avaliacao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objAvaliacao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<EventoDTO>> getAll() {
    	List<Evento> evento = service.findAllEventos();
    	List<EventoDTO> listDTO = evento.stream()
                .sorted(Comparator.comparing(Evento::getDataEvento).reversed())
                .map(obj -> new EventoDTO(obj))
                .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @GetMapping(value = "/avaliacao/{id}")
    public ResponseEntity<List<AvaliacaoDTO>> getAvaliacaoByEvento(@PathVariable int id) {
    	List<Evento> listEvento = service.findAll(id);
    	Evento evento = listEvento.get(0);
    	
    	List<Avaliacao> avaliacao = evento.getAvaliacao();
    	
    	List<AvaliacaoDTO> listDTO = avaliacao.stream()
                .map(obj -> new AvaliacaoDTO(obj))
                .collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }

}
