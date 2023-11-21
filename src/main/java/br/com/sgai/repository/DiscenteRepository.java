package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Discente;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente, Integer>, PagingAndSortingRepository<Discente, Integer>{
		Discente findAllByCpfAndSenha(String cpf, String senha);
		Discente findAllByCpf(String cpf);
		Discente findAllById(int id);
		List<Discente> findAll();
}