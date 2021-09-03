package br.com.rafaelmattos.StarWarsAPI.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;
import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;

public class PlanetResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Required completion")
	@Length(min = 5, max = 80, message = "Length must be between 5 and 80 characters")
	private String name;
	private String movieAppearances;
	private List<Climate> climates;
	private List<Terrain> terrains;

	public PlanetResponse() {
	}

	public PlanetResponse(Planet planet) {
		id = planet.getId();
		name = planet.getName();
		movieAppearances = planet.getMovieAppearances();
		climates = planet.getClimates();
		terrains = planet.getTerrains();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMovieAppearances() {
		return movieAppearances;
	}

	public void setMovieAppearances(String movieAppearances) {
		this.movieAppearances = movieAppearances;
	}

	public List<Climate> getClimates() {
		return climates;
	}

	public void setClimates(List<Climate> climates) {
		this.climates = climates;
	}

	public List<Terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}

}
