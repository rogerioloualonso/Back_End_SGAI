package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>, PagingAndSortingRepository<Avaliacao, Integer>{
		List<Avaliacao> findAllById(Integer id);
}