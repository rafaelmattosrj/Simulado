package br.com.rafaelmattos.StarWarsAPI.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetDto;
import br.com.rafaelmattos.StarWarsAPI.service.PlanetService;

@RestController
@RequestMapping(value = "/planets")
public class PlanetController {

		@Autowired
		private PlanetService service;
		
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<PlanetDto>> findAll() {
			List<Planet> list = service.findAll();
			List<PlanetDto> listDto = list.stream().map(obj -> new PlanetDto(obj)).collect(Collectors.toList());  
			return ResponseEntity.ok().body(listDto);
		}
		
		
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Planet> find(@PathVariable Integer id) {
			Planet obj = service.find(id);
			return ResponseEntity.ok().body(obj);
	}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody Planet obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Planet obj, @PathVariable Integer id) {
			obj.setId(id);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
}
