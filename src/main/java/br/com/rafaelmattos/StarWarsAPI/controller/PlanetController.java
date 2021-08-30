package br.com.rafaelmattos.StarWarsAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.service.PlanetService;

@RestController
@RequestMapping(value = "/planets")
public class PlanetController {

		@Autowired
		private PlanetService service;

		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<?> find(@PathVariable Integer id) {
			Planet obj = service.find(id);
			return ResponseEntity.ok().body(obj);
	}
}
