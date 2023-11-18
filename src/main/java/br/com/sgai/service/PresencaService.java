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
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
