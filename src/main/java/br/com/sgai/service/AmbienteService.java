package br.com.sgai.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Ambiente;
import br.com.sgai.repository.AmbienteRepository;

@Service
public class AmbienteService {

	@Autowired
	private AmbienteRepository repo;

	public List<Ambiente> findAll() {
		return repo.findAll();
	}
	
	public Ambiente findById(int id) {
		return repo.findById(id);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Ambiente insert(Ambiente newObj) {
		return repo.save(newObj);
	}
	
	public void atualizar(Ambiente ambiente) {
	
		ambiente.setUpdatedAt(LocalDateTime.now());
		ambiente = repo.save(ambiente);
	}
}
