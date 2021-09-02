package br.com.rafaelmattos.StarWarsAPI.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Planet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String movieAppearances;
	
	@NotNull
	@ManyToMany(mappedBy = "planets", cascade=CascadeType.PERSIST)
	private List<Climate> climates = new ArrayList<>();
	
	@NotNull
	@ManyToMany(mappedBy = "planets", cascade=CascadeType.PERSIST)
	private List<Terrain> terrains = new ArrayList<>();
			
	public Planet() {
	}

	public Planet(Integer id, String name, String movieAppearances) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}

