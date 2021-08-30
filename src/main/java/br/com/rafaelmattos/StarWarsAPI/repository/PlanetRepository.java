package br.com.rafaelmattos.StarWarsAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {

}
