package br.com.rafaelmattos.StarWarsAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {

	List<Terrain> findByNameIn(List<String> terrains);
	
}
