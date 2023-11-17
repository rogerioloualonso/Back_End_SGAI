package br.com.sgai.service;

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
}
