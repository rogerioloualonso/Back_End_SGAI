package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Presenca;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Integer>, PagingAndSortingRepository<Presenca, Integer>{
		List<Presenca> findAllById(Integer id);
}