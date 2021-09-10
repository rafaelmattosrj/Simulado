package br.com.rafaelmattos.StarWarsAPI.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.transaction.Transactional;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;
import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;
import br.com.rafaelmattos.StarWarsAPI.repository.ClimateRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetRequest;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetResponse;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;
import br.com.rafaelmattos.StarWarsAPI.service.exceptions.DataIntegrityException;
import br.com.rafaelmattos.StarWarsAPI.service.exceptions.ObjectNotFoundException;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private ClimateRepository climateRespository;
    @Autowired
    private TerrainRepository terrainRepository;

    public Planet findPlanet(Integer id) {
        Optional<Planet> planet = planetRepository.findById(id);
        return planet.orElseThrow(
                () -> new ObjectNotFoundException("Planet not found! Id: " + id + ", Tipo: " + Planet.class.getName()));
    }

    public Planet findByName(String name) {
        Optional<Planet> planet = planetRepository.findByName(name);
        return planet.orElseThrow(
                () -> new ObjectNotFoundException("Planet not found! Id: " + name + ", Tipo: " + Planet.class.getName()));
    }

    @Transactional
    public Planet insert(Planet planet) {
//		Climate climate = climateRepository.saveAll(planet.getClimates());
//		Terrain terrain = terrainRepository.saveAll(planet.getTerrains());
//
//		planet.setTerrains(terrain);
//		planet.setClimates(climate);

        planet = planetRepository.save(planet);

        return planet;
    }

    public Planet update(Planet planet) {
        Planet existingObject = findPlanet(planet.getId());

        existingObject.setClimates(climateRespository.saveAll(planet.getClimates()));
        existingObject.setTerrains(terrainRepository.saveAll(planet.getTerrains()));
        existingObject.setName(planet.getName());

        return planetRepository.save(existingObject);
    }

    public void delete(Integer id) {
        findPlanet(id);
        try {
            planetRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Planets cannot be excluded because there are related entities.");
        }
    }

    public List<Planet> findAll() {
        return planetRepository.findAll();
    }

    public Page<Planet> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return planetRepository.findAll(pageRequest);
    }
}
