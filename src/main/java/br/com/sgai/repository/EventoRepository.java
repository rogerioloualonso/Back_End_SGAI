package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>, PagingAndSortingRepository<Evento, Integer>{
		List<Evento> findAllById(Integer id);
}