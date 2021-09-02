package br.com.rafaelmattos.StarWarsAPI.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetRequest;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetResponse;
import br.com.rafaelmattos.StarWarsAPI.service.PlanetService;

@RestController
@RequestMapping(value = "/planets")
public class PlanetController {

		@Autowired
		private PlanetService service;
		
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Planet> find(@PathVariable Integer id) {
			Planet planet = service.find(id);
			return ResponseEntity.ok().body(planet);
	}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody PlanetRequest planetRequest) {
		Planet planet = service.fromDTO(planetRequest);
		planet = service.insert(planet);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(planet.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@Valid @RequestBody PlanetResponse planetResponse, @PathVariable Integer id) {
			Planet planet = service.fromDTO(planetResponse);
			planet.setId(id);
			planet = service.update(planet);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<PlanetResponse>> findAll() {
			List<Planet> planet = service.findAll();
			List<PlanetResponse> planetResponse = planet.stream().map(obj -> new PlanetResponse(obj)).collect(Collectors.toList());  
			return ResponseEntity.ok().body(planetResponse);
		}
		
		@RequestMapping(value="/page", method=RequestMethod.GET)
		public ResponseEntity<Page<PlanetResponse>> findPage(
				@RequestParam(value="page", defaultValue="0") Integer page, 
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
				@RequestParam(value="orderBy", defaultValue="name") String orderBy, 
				@RequestParam(value="direction", defaultValue="ASC") String direction) {
			Page<Planet> planet = service.findPage(page, linesPerPage, orderBy, direction);
			Page<PlanetResponse> planetResponse = planet.map(obj -> new PlanetResponse(obj));  
			return ResponseEntity.ok().body(planetResponse);
		}
}
