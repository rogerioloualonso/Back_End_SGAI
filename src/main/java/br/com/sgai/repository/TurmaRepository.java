package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>, PagingAndSortingRepository<Turma, Integer>{
		@Query("SELECT t FROM Turma t WHERE t.docente.id = :id")
		List<Turma> findAllByIdDocente(int id);
		Turma findById(int id);
}