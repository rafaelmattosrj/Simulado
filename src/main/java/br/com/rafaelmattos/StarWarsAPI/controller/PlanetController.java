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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/planets")
public class PlanetController {

		@Autowired
		private PlanetService planetService;
		
		@ApiOperation(value="Search by id")
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Planet> find(@PathVariable Integer id) {
			Planet planet = planetService.find(id);
			return ResponseEntity.ok().body(planet);
	}
		
		//Com essa implementação da erro na get/{id} de cima.
//		@ApiOperation(value="Search by name")
//		@RequestMapping(value="/{name}", method=RequestMethod.GET)
//		public ResponseEntity<PlanetResponse> findByName(@PathVariable String name) {
//			PlanetResponse planetResponse = planetService.findByName(name);
//			return ResponseEntity.ok().body(planetResponse);
//		}
		
		@ApiOperation(value="Insert planet")
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody PlanetRequest planetRequest) {
		Planet planet = planetService.fromDTO(planetRequest);
		planet = planetService.insert(planet);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(planet.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
		@ApiOperation(value="Update planet")
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@Valid @RequestBody PlanetResponse planetResponse, @PathVariable Integer id) {
			Planet planet = planetService.fromDTO(planetResponse);
			planet.setId(id);
			planet = planetService.update(planet);
			return ResponseEntity.noContent().build();
		}
		
		@ApiOperation(value="Remove planet")
		@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Planets cannot be excluded because there are related entities"),
				@ApiResponse(code = 404, message = "Non-existent code") })
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer id) {
			planetService.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@ApiOperation(value="Return all planets")
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<PlanetResponse>> findAll() {
			List<Planet> planet = planetService.findAll();
			List<PlanetResponse> planetResponse = planet.stream().map(obj -> new PlanetResponse(obj)).collect(Collectors.toList());  
			return ResponseEntity.ok().body(planetResponse);
		}
		
		@ApiOperation(value="Return all planets with pagination")
		@RequestMapping(value="/page", method=RequestMethod.GET)
		public ResponseEntity<Page<PlanetResponse>> findPage(
				@RequestParam(value="page", defaultValue="0") Integer page, 
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
				@RequestParam(value="orderBy", defaultValue="name") String orderBy, 
				@RequestParam(value="direction", defaultValue="ASC") String direction) {
			Page<Planet> planet = planetService.findPage(page, linesPerPage, orderBy, direction);
			Page<PlanetResponse> planetResponse = planet.map(obj -> new PlanetResponse(obj));  
			return ResponseEntity.ok().body(planetResponse);
		}
}
