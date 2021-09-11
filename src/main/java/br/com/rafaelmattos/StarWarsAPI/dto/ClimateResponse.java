package br.com.rafaelmattos.StarWarsAPI.dto;

import java.io.Serializable;

import br.com.rafaelmattos.StarWarsAPI.domain.Climate;

public class ClimateResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	public ClimateResponse() {
		super();
	}

	public ClimateResponse(Climate climate) {
		super();
		this.id = climate.getId();
		this.name = climate.getName();
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
