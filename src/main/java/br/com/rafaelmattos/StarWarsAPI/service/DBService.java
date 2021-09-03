package br.com.rafaelmattos.StarWarsAPI.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;
import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;
import br.com.rafaelmattos.StarWarsAPI.repository.ClimateRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;
import br.com.rafaelmattos.StarWarsAPI.repository.TerrainRepository;

@Service
public class DBService {

	@Autowired
	private PlanetRepository planetRepository;

	@Autowired
	private ClimateRepository climateRepository;

	@Autowired
	private TerrainRepository terrainRepository;
	
	public void instantiateTestDatabase () throws ParseException {

		Climate climate1 = new Climate(null, "arid");
		Climate climate2 = new Climate(null, "temperate");
		Climate climate3 = new Climate(null, "tropical");
		Climate climate4 = new Climate(null, "frozen");
		Climate climate5 = new Climate(null, "murky");

		Terrain terrain1 = new Terrain(null, "desert");
		Terrain terrain2 = new Terrain(null, "grasslands");
		Terrain terrain3 = new Terrain(null, "mountains");
		Terrain terrain4 = new Terrain(null, "jungle");
		Terrain terrain5 = new Terrain(null, "rainforests");
		Terrain terrain6 = new Terrain(null, "tundra");
		Terrain terrain7 = new Terrain(null, "ice caves");
		Terrain terrain8 = new Terrain(null, "mountain ranges");
		Terrain terrain9 = new Terrain(null, "swamp");
		Terrain terrain10 = new Terrain(null, "jungles");
		Terrain terrain11 = new Terrain(null, "gas gianterrain");
		Terrain terrain12 = new Terrain(null, "forests");
		Terrain terrain13 = new Terrain(null, "lakes");
		Terrain terrain14 = new Terrain(null, "grassy hills");
		Terrain terrain15 = new Terrain(null, "swamps");
		Terrain terrain16 = new Terrain(null, "cityscape");
		Terrain terrain17 = new Terrain(null, "ocean");

		Planet planet1 = new Planet(null, "Tatooine", "6");//, Arrays.asList(climate1), Arrays.asList(terrain1));
		Planet planet2 = new Planet(null, "Alderaan", "2");//, Arrays.asList(climate2), Arrays.asList(terrain2, terrain3));
		Planet planet3 = new Planet(null, "Yavin IV", "1");//, Arrays.asList(climate2, climate3), Arrays.asList(terrain4, terrain5));
		Planet planet4 = new Planet(null, "Hoth", "1");//, Arrays.asList(climate4), Arrays.asList(terrain6, terrain7, terrain8));
		Planet planet5 = new Planet(null, "Dagobah", "3");//, Arrays.asList(climate5), Arrays.asList(terrain9, terrain10));
		Planet planet6 = new Planet(null, "Bespin", "1");//, Arrays.asList(climate2), Arrays.asList(terrain11));
		Planet planet7 = new Planet(null, "Endor", "1");//, Arrays.asList(climate2), Arrays.asList(terrain12, terrain3, terrain13));
		Planet planet8 = new Planet(null, "Naboo", "4");
		Planet planet9 = new Planet(null, "Coruscant", "4");
		Planet planet10 = new Planet(null, "Kamino", "1");
//		Planet planet11 = new Planet(null, "Geonosis", "1");
//		Planet planet12 = new Planet(null, "Utapau", "1");
//		Planet planet13 = new Planet(null, "Mustafar", "1");
//		Planet planet14 = new Planet(null, "Kashyyyk", "2");
//		Planet planet15 = new Planet(null, "Polis Massa", "1");
//		Planet planet16 = new Planet(null, "Mygeeto", "1");
//		Planet planet17 = new Planet(null, "Felucia", "1");
//		Planet planet18 = new Planet(null, "Cato Neimoidia", "1");
//		Planet planet19 = new Planet(null, "Saleucami", "1");
//		Planet planet20 = new Planet(null, "Stewjon", "1");
		
		planet1.getClimates().addAll(Arrays.asList(climate1));
		planet2.getClimates().addAll(Arrays.asList(climate2));
		planet3.getClimates().addAll(Arrays.asList(climate2, climate3));
		planet4.getClimates().addAll(Arrays.asList(climate4));
		planet5.getClimates().addAll(Arrays.asList(climate5));
		planet6.getClimates().addAll(Arrays.asList(climate2));
		planet7.getClimates().addAll(Arrays.asList(climate2));
		planet8.getClimates().addAll(Arrays.asList(climate2));
		planet9.getClimates().addAll(Arrays.asList(climate2));
		planet10.getClimates().addAll(Arrays.asList(climate2));

		planet1.getTerrains().addAll(Arrays.asList(terrain1));
		planet2.getTerrains().addAll(Arrays.asList(terrain2, terrain3));
		planet3.getTerrains().addAll(Arrays.asList(terrain4, terrain5));
		planet4.getTerrains().addAll(Arrays.asList(terrain6, terrain7, terrain8));
		planet5.getTerrains().addAll(Arrays.asList(terrain9, terrain10));
		planet6.getTerrains().addAll(Arrays.asList(terrain11));
		planet7.getTerrains().addAll(Arrays.asList(terrain12, terrain3, terrain13));
		planet8.getTerrains().addAll(Arrays.asList(terrain14, terrain15, terrain12, terrain3));
		planet9.getTerrains().addAll(Arrays.asList(terrain16, terrain3));
		planet10.getTerrains().addAll(Arrays.asList(terrain17));

		climate1.getPlanets().addAll(Arrays.asList(planet1));
		climate2.getPlanets().addAll(Arrays.asList(planet2, planet3, planet6, planet7, planet8, planet9, planet10));
		climate3.getPlanets().addAll(Arrays.asList(planet3));
		climate4.getPlanets().addAll(Arrays.asList(planet4));
		climate5.getPlanets().addAll(Arrays.asList(planet5));

		terrain1.getPlanets().addAll(Arrays.asList(planet1));
		terrain2.getPlanets().addAll(Arrays.asList(planet2));
		terrain3.getPlanets().addAll(Arrays.asList(planet2, planet7, planet8, planet9));
		terrain4.getPlanets().addAll(Arrays.asList(planet3));
		terrain5.getPlanets().addAll(Arrays.asList(planet3));
		terrain6.getPlanets().addAll(Arrays.asList(planet4));
		terrain7.getPlanets().addAll(Arrays.asList(planet4));
		terrain8.getPlanets().addAll(Arrays.asList(planet4));
		terrain9.getPlanets().addAll(Arrays.asList(planet5));
		terrain10.getPlanets().addAll(Arrays.asList(planet5));
		terrain11.getPlanets().addAll(Arrays.asList(planet6));
		terrain12.getPlanets().addAll(Arrays.asList(planet7, planet8));
		terrain13.getPlanets().addAll(Arrays.asList(planet7));
		terrain14.getPlanets().addAll(Arrays.asList(planet8));
		terrain15.getPlanets().addAll(Arrays.asList(planet8));
		terrain16.getPlanets().addAll(Arrays.asList(planet9));
		terrain16.getPlanets().addAll(Arrays.asList(planet10));

		planetRepository.saveAll(Arrays.asList(planet1, planet2, planet3, planet4, planet5, planet6, planet7, planet8, planet9, planet10));
		climateRepository.saveAll(Arrays.asList(climate1, climate2, climate3, climate4, climate5));
		terrainRepository.saveAll(Arrays.asList(terrain1, terrain2, terrain3, terrain4, terrain5, terrain6, terrain7, terrain8, terrain9, terrain10, 
				terrain11, terrain12, terrain13, terrain14, terrain15, terrain16));
	}
}
