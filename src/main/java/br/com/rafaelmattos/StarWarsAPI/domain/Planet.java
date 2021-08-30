package br.com.rafaelmattos.StarWarsAPI.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Planet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String climates;
	private String terrains;
	private String movieAppearances;
	
	public Planet() {
	}

	public Planet(Integer id, String name, String climates, String terrains, String movieAppearances) {
		super();
		this.id = id;
		this.name = name;
		this.climates = climates;
		this.terrains = terrains;
		this.movieAppearances = movieAppearances;
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

	public String getClimates() {
		return climates;
	}

	public void setClimates(String climates) {
		this.climates = climates;
	}

	public String getTerrains() {
		return terrains;
	}

	public void setTerrains(String terrains) {
		this.terrains = terrains;
	}

	public String getMovieAppearances() {
		return movieAppearances;
	}

	public void setMovieAppearances(String movieAppearances) {
		this.movieAppearances = movieAppearances;
	}
	
}

