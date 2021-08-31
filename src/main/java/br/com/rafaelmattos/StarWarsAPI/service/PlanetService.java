package br.com.rafaelmattos.StarWarsAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.StarWarsAPI.domain.Planet;
import br.com.rafaelmattos.StarWarsAPI.repository.PlanetRepository;
import br.com.rafaelmattos.StarWarsAPI.service.exceptions.DataIntegrityException;
import br.com.rafaelmattos.StarWarsAPI.service.exceptions.ObjectNotFoundException;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository repo;

	public Planet find(Integer id) {
		Optional<Planet> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Planet not found! Id: " + id + ", Tipo: " + Planet.class.getName()));
	}

	public Planet insert(Planet obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Planet update(Planet obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is not possible to delete a planet that has listed attributes.");
		}
	}
	
	public List<Planet> findAll() {
		return repo.findAll();
	}
	
	public Page<Planet> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
