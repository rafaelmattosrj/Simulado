package br.com.rafaelmattos.StarWarsAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {

	@Transactional(readOnly = true)
	Optional<Terrain> findByNameIn(List<Terrain> terrains);
	
}
