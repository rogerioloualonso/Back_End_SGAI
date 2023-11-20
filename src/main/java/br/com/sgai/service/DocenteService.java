package br.com.sgai.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgai.domain.Ambiente;
import br.com.sgai.domain.Docente;
import br.com.sgai.repository.DocenteRepository;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepository repo;

	public Docente findAllByCpfAndSenha(String cpf, String senha) {
		return repo.findAllByCpfAndSenha(cpf, senha);
	}
	
	public Docente findAllByCpf(String cpf) {
		return repo.findAllByCpf(cpf);
	}
	
	public Docente findById(int id) {
		return repo.findById(id);
	}
	
	public List<Docente> findAll() {
		return repo.findAll();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Docente insert(Docente newObj) {
		return repo.save(newObj);
	}
	
	public void atualizar(Docente docente) {
		
		docente.setUpdatedAt(LocalDateTime.now());
		docente = repo.save(docente);
	}
}
