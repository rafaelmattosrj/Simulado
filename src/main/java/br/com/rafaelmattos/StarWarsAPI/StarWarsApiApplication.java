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
		Planet pla3 = new Planet(null, "Yavin IV", "1");
		Planet pla4 = new Planet(null, "Hoth", "1");
		Planet pla5 = new Planet(null, "Dagobah", "3");
		Planet pla6 = new Planet(null, "Bespin", "1");
		Planet pla7 = new Planet(null, "Endor", "1");

		Climate c1 = new Climate(null, "arid");
		Climate c2 = new Climate(null, "temperate");
		Climate c3 = new Climate(null, "tropical");
		Climate c4 = new Climate(null, "frozen");
		Climate c5 = new Climate(null, "murky");
		
		Terrain t1 = new Terrain(null, "desert");
		Terrain t2 = new Terrain(null, "grasslands");
		Terrain t3 = new Terrain(null, "mountains");
		Terrain t4 = new Terrain(null, "jungle");
		Terrain t5 = new Terrain(null, "rainforests");
		Terrain t6 = new Terrain(null, "tundra");
		Terrain t7 = new Terrain(null, "ice caves");
		Terrain t8 = new Terrain(null, "mountain ranges");
		Terrain t9 = new Terrain(null, "swamp");
		Terrain t10 = new Terrain(null, "jungles");
		Terrain t11 = new Terrain(null, "gas giant");
		Terrain t12 = new Terrain(null, "forests");
		Terrain t13 = new Terrain(null, "lakes");

		pla1.getClimates().addAll(Arrays.asList(c1));
		pla2.getClimates().addAll(Arrays.asList(c2));
		pla3.getClimates().addAll(Arrays.asList(c2, c3));
		pla4.getClimates().addAll(Arrays.asList(c4));
		pla5.getClimates().addAll(Arrays.asList(c5));
		pla6.getClimates().addAll(Arrays.asList(c2));
		pla7.getClimates().addAll(Arrays.asList(c2));
		
		pla1.getTerrains().addAll(Arrays.asList(t1));
		pla2.getTerrains().addAll(Arrays.asList(t2, t3));
		pla3.getTerrains().addAll(Arrays.asList(t4, t5));
		pla4.getTerrains().addAll(Arrays.asList(t6, t7, t8));
		pla5.getTerrains().addAll(Arrays.asList(t9, t10));
		pla6.getTerrains().addAll(Arrays.asList(t11));
		pla7.getTerrains().addAll(Arrays.asList(t12, t3, t13));
		
		c1.getPlanets().addAll(Arrays.asList(pla1));
		c2.getPlanets().addAll(Arrays.asList(pla2, pla3, pla6, pla7));
		c3.getPlanets().addAll(Arrays.asList(pla3));
		c4.getPlanets().addAll(Arrays.asList(pla4));
		c5.getPlanets().addAll(Arrays.asList(pla5));
		
		t1.getPlanets().addAll(Arrays.asList(pla1));
		t2.getPlanets().addAll(Arrays.asList(pla2));
		t3.getPlanets().addAll(Arrays.asList(pla2, pla7));
		t4.getPlanets().addAll(Arrays.asList(pla3));
		t5.getPlanets().addAll(Arrays.asList(pla3));
		t6.getPlanets().addAll(Arrays.asList(pla4));
		t7.getPlanets().addAll(Arrays.asList(pla4));
		t8.getPlanets().addAll(Arrays.asList(pla4));
		t9.getPlanets().addAll(Arrays.asList(pla5));
		t10.getPlanets().addAll(Arrays.asList(pla5));
		t11.getPlanets().addAll(Arrays.asList(pla6));
		t12.getPlanets().addAll(Arrays.asList(pla7));
		t13.getPlanets().addAll(Arrays.asList(pla7));

		planetRepository.saveAll(Arrays.asList(pla1, pla2, pla3, pla4, pla5, pla6, pla7));
		climateRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		terrainRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
	}
} 
