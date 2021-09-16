package br.com.rafaelmattos.StarWarsAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;

@Repository
public interface ClimateRepository extends JpaRepository<Climate, Integer> {

	@Transactional(readOnly = true)
	Optional<Climate> findByNameIn(List<Climate> list);
	
}
