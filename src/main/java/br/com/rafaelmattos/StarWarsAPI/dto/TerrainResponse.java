package br.com.rafaelmattos.StarWarsAPI.dto;

import java.io.Serializable;

import br.com.rafaelmattos.StarWarsAPI.domain.Terrain;

public class TerrainResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	public TerrainResponse() {
		super();
	}

	public TerrainResponse(Terrain terrain) {
		super();
		this.id = terrain.getId();
		this.name = terrain.getName();
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
	
}