package br.com.rafaelmattos.StarWarsAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetResponse;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {

//	@Transactional(readOnly = true)
//	Optional<Planet> findById(String id);
	
	@Transactional(readOnly = true)
	Optional<PlanetResponse> findByName(String name);

	
}
