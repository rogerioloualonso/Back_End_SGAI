package br.com.sgai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>, PagingAndSortingRepository<Evento, Integer>{
		List<Evento> findAllById(Integer id);
		@Query("SELECT t FROM Evento t, Turma b WHERE t.turma.id = b.id AND b.docente.id = :id")
		List<Evento> findAllByIdDocente(int id);
		Optional<Evento> findById(Integer id);
}