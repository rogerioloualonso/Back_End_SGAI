package br.com.sgai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Ambiente;
import br.com.sgai.domain.Evento;
import br.com.sgai.domain.Turma;
import br.com.sgai.dto.EventonewDTO;
import br.com.sgai.enums.Situacao;
import br.com.sgai.repository.AmbienteRepository;
import br.com.sgai.repository.EventoRepository;
import br.com.sgai.repository.TurmaRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repo;
	
	@Autowired
	private AmbienteRepository repositoryAmbiente;
	
	@Autowired
	private TurmaRepository repositoryTurma;

	public List<Evento> findAll(Integer id) {
		return repo.findAllById(id);
	}
	
	public List<Evento> findAllEventos() {
		return repo.findAll();
	}
	
	public List<Evento> findByIdDocente(Integer id) {
		return repo.findAllByIdDocente(id);
	}
	
	public Evento newFromDTO(EventonewDTO objDto) {
		Evento obj = new Evento(objDto.getId(), objDto.getSituacao(),
				objDto.getData(), objDto.getHoraInicio(), objDto.getHoraFim(), LocalDateTime.now());
		return obj;
	}
	
	public Evento insert(Evento newObj, int idAmbiente, int idTurma) {
		
		Turma turma = repositoryTurma.findById(idTurma);
		Ambiente ambiente  = repositoryAmbiente.findById(idAmbiente);
		
		newObj.setAmbiente(ambiente);
		newObj.setTurma(turma);
		
		return repo.save(newObj);
	}
	
	public void iniciar(int id) {
		
		Optional<Evento> eventoOptional = repo.findById(id);
		Evento evento = eventoOptional.get();
		evento.setSituacao(Situacao.INICIADO.toString());
		evento.setUpdatedAt(LocalDateTime.now());
		
		evento = repo.save(evento);
	}
	
	public void finalizar(int id) {
		
		Optional<Evento> eventoOptional = repo.findById(id);
		Evento evento = eventoOptional.get();
		evento.setSituacao(Situacao.FINALIZADO.toString());
		evento.setUpdatedAt(LocalDateTime.now());
		
		evento = repo.save(evento);
	}
	
	public void aprovar(int id) {
		
		Optional<Evento> eventoOptional = repo.findById(id);
		Evento evento = eventoOptional.get();
		evento.setSituacao(Situacao.APROVADO.toString());
		evento.setUpdatedAt(LocalDateTime.now());
		
		evento = repo.save(evento);
	}
	
	public void reprovar(int id) {
		
		Optional<Evento> eventoOptional = repo.findById(id);
		Evento evento = eventoOptional.get();
		evento.setSituacao(Situacao.REPROVADO.toString());
		evento.setUpdatedAt(LocalDateTime.now());
		
		evento = repo.save(evento);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
