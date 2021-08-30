package br.com.rafaelmattos.StarWarsAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;

@RestController
@RequestMapping(value = "/planets")
public class PlanetController {

	@RequestMapping(method = RequestMethod.GET)
	public List<Planet> list() {

		Planet pla1 = new Planet(1, "Tatooine", "arid", "desert", "5");
		Planet pla2 = new Planet(2, "Alderaan", "temperate", "grasslands", "2");

		List<Planet> list = new ArrayList<>();
		list.add(pla1);
		list.add(pla2);

		return list;
	}
}
