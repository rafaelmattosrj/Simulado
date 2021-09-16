package br.com.rafaelmattos.StarWarsAPI.utils;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;
import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;
import br.com.rafaelmattos.StarWarsAPI.repository.ClimateRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.TerrainRepository;

@Component
public class Validation {

	@Autowired
	PlanetRepository planetRepository;

	@Autowired
	ClimateRepository climateRepository;

	@Autowired
	TerrainRepository terrainRepository;
	

	public boolean checkIfPlanetExistInDatabaseById(String planetId) {
		
		Optional<Planet> planet = planetRepository.findById(planetId);

		if (planet.isPresent()) {
			return true;
		}
		return false;

	}
	
	public boolean checkIfPlanetExistInDatabaseByName(String planetName) {

		Optional<Planet> planet = planetRepository.findByName(planetName);

		if (planet.isPresent()) {
			return true;
		}
		return false;

	}

	public boolean climate(List<Climate> climateList) {
		
		Optional<Climate> climate = climateRepository.findByNameIn(climateList);

		if (climate.isPresent()) {
			return true;
		}
		return false;

	}
	
	public boolean terrain(List<Terrain> terrainList) {
		
		Optional<Terrain> terrain = terrainRepository.findByNameIn(terrainList);

		if (terrain.isPresent()) {
			return true;
		}
		return false;

	}
	
//	public boolean climate(List<Climate> climates) {
//
////		Collections.sort(climates);
//		List<Climate> climatesExisting = climateRepository.findByNameIn(climates);
//		List<String> climatesExistingString = climatesExisting.stream().map(c -> c.getName())
//				.collect(Collectors.toList());
//		Collections.sort(climatesExistingString);
//		
//		if (climates.equals((climatesExistingString)) && !(climatesExistingString.isEmpty())) {
//			return true;
//		}
//		return false;
//	}

//	public boolean terrain(List<Terrain> terrains) {
//
////		Collections.sort(terrains);
//		List<Terrain> terrainsExisting = terrainRepository.findByNameIn(terrains);
//		List<String> terrainsExistingString = terrainsExisting.stream().map(c -> c.getName())
//				.collect(Collectors.toList());
//		Collections.sort(terrainsExistingString);
//
//		if (terrains.equals((terrainsExistingString)) && !(terrainsExistingString.isEmpty())) {
//			return true;
//		}
//		return false;
//	}
	
}