package br.com.rafaelmattos.StarWarsAPI;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;

@SpringBootApplication
public class StarWarsApiApplication implements CommandLineRunner {

	@Autowired
	private PlanetRepository planetRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StarWarsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Planet pla1 = new Planet(null, "Tatooine", "arid", "desert", "6");
		Planet pla2 = new Planet(null, "Alderaan", "temperate", "grasslands", "2");

		planetRepository.saveAll(Arrays.asList(pla1, pla2));
	}
} 
