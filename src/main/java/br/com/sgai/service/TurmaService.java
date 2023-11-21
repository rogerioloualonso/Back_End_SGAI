package br.com.sgai.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Turma;
import br.com.sgai.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;

	public List<Turma> findAllByIdDocente(int id) {
		return repo.findAllByIdDocente(id);
	}
	
	public List<Turma> findAllByIdDiscente(int id) {
		return repo.findAllByIdDocente(id);
	}
	
	public List<Turma> findAll() {
		return repo.findAll();
	}
	
	public Turma findById(int id) {
		return repo.findById(id);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Turma insert(Turma newObj) {
		return repo.save(newObj);
	}
	
	public void atualizar(Turma turma) {
		
		turma.setUpdatedAt(LocalDateTime.now());
		turma = repo.save(turma);
	}
}
