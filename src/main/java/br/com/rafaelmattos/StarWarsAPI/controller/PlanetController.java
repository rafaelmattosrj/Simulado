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

import br.com.rafaelmattos.StarWarsAPI.converter.PlanetConverter;
import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetRequest;
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetResponse;
import br.com.rafaelmattos.StarWarsAPI.service.PlanetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

//TODO: Alterar planets alguns
//recursos que não necessariamente retorna uma lista de planetas.
@RequestMapping(value = "/starB2W")
public class PlanetController {

  @Autowired
  private PlanetService planetService;
  @Autowired
  private PlanetConverter planetConverter;
 
  @ApiOperation(value = "Return all planets")
  @RequestMapping(value = "planets",method = RequestMethod.GET)
  public ResponseEntity<List<PlanetResponse>> findAllPlanets() {
      List<Planet> planet = planetService.findAllPlanets();
      List<PlanetResponse> planetResponse = planet.stream().map(obj -> new PlanetResponse(obj)).collect(Collectors.toList());
      return ResponseEntity.ok().body(planetResponse);
  }
  
  @ApiOperation(value = "Return all planets with pagination")
  @RequestMapping(value = "/planets/page", method = RequestMethod.GET)
	@ApiResponses(value = @ApiResponse(code = 404, message = "The list of planet is empty."))
  public ResponseEntity<Page<PlanetResponse>> findPlanetsPage(
          @RequestParam(value = "page", defaultValue = "0") Integer page,
          @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
          @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
          @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
      Page<Planet> planet = planetService.findPage(page, linesPerPage, orderBy, direction);
      Page<PlanetResponse> planetResponse = planet.map(obj -> new PlanetResponse(obj));
      return ResponseEntity.ok().body(planetResponse);
  }
  
  //TODO: Melhorar a descriçao
  @ApiOperation(value = "Search planet by id.")
  @RequestMapping(value = "planet/{id}", method = RequestMethod.GET)
  //TODO: Melhorar o nome do metodo
  public ResponseEntity<Planet> findPlanetById(@PathVariable Integer id) {
      Planet planet = planetService.findPlanetById(id);
      return ResponseEntity.ok().body(planet);
  }

  //TODO: Melhorar a especificaçao da descriçao
  @ApiOperation(value = "Search planet by name.")
  @RequestMapping(value = "planet/name/{name}", method = RequestMethod.GET)
  //TODO: Melhorar o nome do metodo
  public ResponseEntity<Planet> findPlanetByParameter(@PathVariable String name) {
      Planet planet = planetService.findPlanetByName(name);
      return ResponseEntity.ok().body(planet);
  }
      
  @ApiOperation(value = "Create planet")
  //TODO: Incluir path especificio para o planeta.
  @RequestMapping(path = "/planet", method = RequestMethod.POST)
  public ResponseEntity<Void> createPlanet(@Valid @RequestBody PlanetRequest planetRequest) {

      Planet planet = planetConverter.planetRequestToPlanet(planetRequest);

      planet = planetService.createPlanet(planet);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
              .path("/{id}").buildAndExpand(planet.getId()).toUri();
      return ResponseEntity.created(uri).build();
  }

  @ApiOperation(value = "Update planet")
  @RequestMapping(path = "/planet/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> updatePlanet(@Valid @RequestBody PlanetRequest planetRequest, @PathVariable Integer id) {
      
	  Planet planet = planetConverter.planetRequestToPlanet(planetRequest);
      
	  planet.setId(id);
      planetService.updatePlanet(planet);
      return ResponseEntity.noContent().build();
  }

  @ApiOperation(value = "Remove planet")
  @ApiResponses(value = {
		  @ApiResponse(code = 200, message = "Deleted Successfully."),
          @ApiResponse(code = 400, message = "Planets cannot be excluded because there are related entities.")})
  @RequestMapping(value = "planet/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deletePlanetById(@PathVariable Integer id) {
      planetService.deletePlanetById(id);
      return ResponseEntity.noContent().build();
  }

}
