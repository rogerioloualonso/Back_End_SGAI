package br.com.sgai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Discente;
import br.com.sgai.repository.DiscenteRepository;

@Service
public class DiscenteService {

	@Autowired
	private DiscenteRepository repo;

	public Discente findAllByCpfAndSenha(String cpf, String senha) {
		return repo.findAllByCpfAndSenha(cpf, senha);
	}
	
	public Discente findAllByCpf(String cpf) {
		return repo.findAllByCpf(cpf);
	}
}
