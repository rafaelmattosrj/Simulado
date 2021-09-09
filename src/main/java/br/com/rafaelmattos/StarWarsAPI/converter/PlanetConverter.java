package br.com.rafaelmattos.StarWarsAPI.converter;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetRequest;
import org.springframework.stereotype.Component;

@Component
public class PlanetConverter {

    public void planetConverter() {

    }

    public Planet planetRequestToPlanet(PlanetRequest planetRequest) {

    Planet planet = new Planet();
    planet.setName(planetRequest.getName());
    planet.setTerrains(planetRequest.getTerrains());
    planet.setClimates(planetRequest.getClimates());

    return planet;
    }
}
