package br.com.sgai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Avaliacao;
import br.com.sgai.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repo;
	
	public Avaliacao insert(Avaliacao newObj) {
		return repo.save(newObj);
	}
	
}
