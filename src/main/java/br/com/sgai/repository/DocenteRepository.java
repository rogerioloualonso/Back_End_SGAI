package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer>, PagingAndSortingRepository<Docente, Integer>{
	Docente findAllByCpfAndSenha(String cpf, String senha);
	Docente findAllByCpf(String cpf);
	Docente findById(int id);
	List<Docente> findAll();
}