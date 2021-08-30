package br.com.rafaelmattos.StarWarsAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository repo;

	public Planet find(Integer id) {
		Optional<Planet> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
