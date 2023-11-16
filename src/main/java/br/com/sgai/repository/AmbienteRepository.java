package br.com.sgai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sgai.domain.Ambiente;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Integer>, PagingAndSortingRepository<Ambiente, Integer>{
		List<Ambiente> findAllById(Integer id);
}