package br.com.sgai.service;

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
}
