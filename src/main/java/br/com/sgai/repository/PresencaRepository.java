package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Presenca;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Integer>, PagingAndSortingRepository<Presenca, Integer>{
		Presenca findAllById(Integer id);
		@Query("SELECT t FROM Presenca t WHERE t.discente.id = :id")
		List<Presenca> findAllByIdDiscente(int id);
		@Query("SELECT t FROM Presenca t WHERE t.evento.id = :id")
		List<Presenca> findAllByIdEvento(int id);
}