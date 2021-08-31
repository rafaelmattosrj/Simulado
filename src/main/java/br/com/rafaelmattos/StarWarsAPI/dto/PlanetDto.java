package br.com.rafaelmattos.StarWarsAPI.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;
import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;

public class PlanetDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String movieAppearances;
	private List<Climate> climates = new ArrayList<>();
	private List<Terrain> terrains = new ArrayList<>();

	public PlanetDto() {
	}

	public PlanetDto(Planet obj) {
			id = obj.getId();
			name = obj.getName();
			movieAppearances = obj.getMovieAppearances();
			climates = obj.getClimates();
			terrains = obj.getTerrains();
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
