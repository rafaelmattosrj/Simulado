package br.com.rafaelmattos.StarWarsAPI.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetRequest;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetResponse;

@Component
public class Converter {

	public void planetConverter() {

	}
		
	public List<PlanetResponse> ToPlanetResponse(Optional<List<Planet>> planets) {

		if (planets.isPresent()) {

			List<PlanetResponse> planetsResponse = planets.get()
					.stream()
					.map(PlanetResponse::new)
					//.map(obj -> new PlanetResponse(obj))
					.collect(Collectors.toList());

			return planetsResponse;
		}
		return null;
	}

	public Page<PlanetResponse> ToPlanetResponse(Page<Planet> planets) {
		if (planets == null) {
			return null;
		}
		Page<PlanetResponse> planetsResponse = planets
				.map(obj -> new PlanetResponse(obj));
		return planetsResponse;
	}

	public Planet RequestToPlanet(PlanetRequest planetRequest) {

		Planet planet = new Planet();

		planet.setName(planetRequest.getName());
		planet.setTerrains(planetRequest.getTerrains());
		planet.setClimates(planetRequest.getClimates());

		return planet;
	}
	
	public Optional<PlanetResponse> ToPlanetResponse(Planet planet) {

		if (!(planet == null)) {
			PlanetResponse planetResponse = new PlanetResponse();

			planetResponse.setId(planet.getId());
			planetResponse.setName(planet.getName());
			planetResponse.setMovieAppearances(planet.getMovieAppearances());
			planetResponse.setClimates(planet.getClimates());
			planetResponse.setTerrains(planet.getTerrains());

			return Optional.of(planetResponse);
		}
		return null;
	}
		
//	public Terrain RequestToTerrain(TerrainRequest terrainRequest) {
//		Terrain terrain = new Terrain();
//		terrain.setName(terrainRequest.getName());
//		return terrain;
//	}
//	
//	public Climate RequestToClimate(ClimateRequest climateRequest) {
//		Climate climate = new Climate();
//		climate.setName(climateRequest.getName());
//		return climate;
//	}
//
//	
//	public ClimateResponse ToClimateResponse(Climate climate) {
//		if (!(climate == null)) {
//			ClimateResponse climateResponse = new ClimateResponse();
//			climateResponse.setId(climate.getId());
//			climateResponse.setName(climate.getName());
//			return climateResponse;
//		}
//		return null;
//	}
//
//	public TerrainResponse ToTerrainResponse(Terrain terrain) {
//		if (!(terrain == null)) {
//			TerrainResponse terrainResponse = new TerrainResponse();
//			terrainResponse.setId(terrain.getId());
//			terrainResponse.setName(terrain.getName());
//			return terrainResponse;
//		}
//		return null;
//	}
}





