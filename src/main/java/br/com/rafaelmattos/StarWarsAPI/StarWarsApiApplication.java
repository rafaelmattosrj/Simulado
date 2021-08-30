package br.com.rafaelmattos.StarWarsAPI;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;
import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.repository.ClimateRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;

@SpringBootApplication
public class StarWarsApiApplication implements CommandLineRunner {

	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private ClimateRepository climateRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StarWarsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Planet pla1 = new Planet(null, "Tatooine", "desert", "6");
		Planet pla2 = new Planet(null, "Alderaan", "grasslands", "2");

		Climate c1 = new Climate(null, "arid");
		Climate c2 = new Climate(null, "temperate");

		pla1.getClimates().addAll(Arrays.asList(c1));
		pla2.getClimates().addAll(Arrays.asList(c2));

		c1.getPlanets().addAll(Arrays.asList(pla1));
		c2.getPlanets().addAll(Arrays.asList(pla2));

		planetRepository.saveAll(Arrays.asList(pla1, pla2));
		climateRepository.saveAll(Arrays.asList(c1, c2));
	}
} 
