package br.com.rafaelmattos.StarWarsAPI.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;
import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;

public class PlanetRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private List<Climate> climates = new ArrayList<>();
	private List<Terrain> terrains = new ArrayList<>();

	public PlanetRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
