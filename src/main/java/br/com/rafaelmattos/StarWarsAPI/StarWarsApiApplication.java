package br.com.rafaelmattos.StarWarsAPI;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;
import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;
import br.com.rafaelmattos.StarWarsAPI.repository.ClimateRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.TerrainRepository;

@SpringBootApplication
public class StarWarsApiApplication implements CommandLineRunner {

	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private ClimateRepository climateRepository;
	
	@Autowired
	private TerrainRepository terrainRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StarWarsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Planet pla1 = new Planet(null, "Tatooine", "6");
		Planet pla2 = new Planet(null, "Alderaan", "2");

		Climate c1 = new Climate(null, "arid");
		Climate c2 = new Climate(null, "temperate");
		
		Terrain t1 = new Terrain(null, "desert");
		Terrain t2 = new Terrain(null, "grasslands");
		Terrain t3 = new Terrain(null, "mountains");

		pla1.getTerrains().addAll(Arrays.asList(t1));
		pla2.getTerrains().addAll(Arrays.asList(t2, t3));
		
		pla1.getClimates().addAll(Arrays.asList(c1));
		pla2.getClimates().addAll(Arrays.asList(c2));

		c1.getPlanets().addAll(Arrays.asList(pla1));
		c2.getPlanets().addAll(Arrays.asList(pla2));
		
		t1.getPlanets().addAll(Arrays.asList(pla1));
		t2.getPlanets().addAll(Arrays.asList(pla2));
		t3.getPlanets().addAll(Arrays.asList(pla2));

		planetRepository.saveAll(Arrays.asList(pla1, pla2));
		climateRepository.saveAll(Arrays.asList(c1, c2));
		terrainRepository.saveAll(Arrays.asList(t1, t2, t3));
	}
} 
