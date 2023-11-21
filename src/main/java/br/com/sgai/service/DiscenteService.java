package br.com.sgai.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Discente;
import br.com.sgai.domain.Docente;
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
	
	public Discente findAllById(int id) {
		return repo.findAllById(id);
	}
	
	public List<Discente> findAll() {
		return repo.findAll();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Discente insert(Discente newObj) {
		return repo.save(newObj);
	}
	
	public void atualizar(Discente discente) {
	
		discente.setUpdatedAt(LocalDateTime.now());
		discente = repo.save(discente);
	}
	
	
}
