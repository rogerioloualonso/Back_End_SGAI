package br.com.sgai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Docente;
import br.com.sgai.repository.DocenteRepository;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepository repo;

	public Docente findAllByCpfAndSenha(String cpf, String senha) {
		return repo.findAllByCpfAndSenha(cpf, senha);
	}
}
