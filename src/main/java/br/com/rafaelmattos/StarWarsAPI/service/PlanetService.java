package br.com.rafaelmattos.StarWarsAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetRequest;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetResponse;
import br.com.rafaelmattos.StarWarsAPI.repository.ClimateRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.TerrainRepository;
import br.com.rafaelmattos.StarWarsAPI.service.exceptions.DataIntegrityException;
import br.com.rafaelmattos.StarWarsAPI.service.exceptions.ObjectNotFoundException;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private ClimateRepository climateRepository;
	
	@Autowired
	private TerrainRepository terrainRepository;
	
	public Planet find(Integer id) {
		Optional<Planet> planet = planetRepository.findById(id);
		return planet.orElseThrow(
				() -> new ObjectNotFoundException("Planet not found! Id: " + id + ", Tipo: " + Planet.class.getName()));
	}

	@Transactional
	public Planet insert(Planet planet) {
		planet.setId(null);
		planet = planetRepository.save(planet);
		climateRepository.saveAll(planet.getClimates());
		terrainRepository.saveAll(planet.getTerrains());
		return planet;
	}

	public Planet update(Planet planet) {
		Planet newObject = find(planet.getId());
		updateData(newObject, planet);
		return planetRepository.save(newObject);
	}

	public void delete(Integer id) {
		find(id);
		try {
			planetRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete because there are related entities.");
		}
	}
	
	public List<Planet> findAll() {
		return planetRepository.findAll();
	}
	
	public Page<Planet> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return planetRepository.findAll(pageRequest);
	}
	
	public Planet fromDTO(PlanetResponse planetResponse) {
		return new Planet(
				planetResponse.getId(), 
				planetResponse.getName(), 
				planetResponse.getMovieAppearances());
	}
	
	public Planet fromDTO(PlanetRequest planetRequest) {
		Planet planet = new Planet(null, planetRequest.getName(), null);
		
//		planet.getClimates().add(planetRequest.getClimate1());
//		if (planetRequest.getClimate2()!=null) {
//			planet.getClimates().add(planetRequest.getClimate2());
//		}
//		if (planetRequest.getClimate3()!=null) {
//			planet.getClimates().add(planetRequest.getClimate3());
//			return planet;
//		}
//		planet.getTerrains().add(null);
		return planet;
	}
	
	private void updateData(Planet newObject, Planet planet) {
		newObject.setName(planet.getName());
		newObject.setMovieAppearances(planet.getMovieAppearances());
		newObject.setClimates(planet.getClimates());
		newObject.setTerrains(planet.getTerrains());
	}
	
}
