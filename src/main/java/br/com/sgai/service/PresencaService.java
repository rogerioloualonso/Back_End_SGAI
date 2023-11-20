package br.com.sgai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Presenca;
import br.com.sgai.repository.PresencaRepository;

@Service
public class PresencaService {

	@Autowired
	private PresencaRepository repo;

	public List<Presenca> findAllByIdDiscente(int id) {
		return repo.findAllByIdDiscente(id);
	}
	
	public Presenca findAllById(int id) {
		return repo.findAllById(id);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Presenca insert(Presenca newObj) {
		return repo.save(newObj);
	}
	
	public Presenca update(Presenca newObj) {
		return repo.save(newObj);
	}
	
}
