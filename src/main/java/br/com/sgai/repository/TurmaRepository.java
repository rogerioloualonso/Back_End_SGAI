package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>, PagingAndSortingRepository<Turma, Integer>{
		List<Turma> findAllById(Integer id);
}