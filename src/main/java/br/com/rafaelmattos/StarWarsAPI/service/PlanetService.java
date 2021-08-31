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
import br.com.rafaelmattos.StarWarsAPI.dto.PlanetDto;
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
		Planet newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Planet newObj, Planet obj) {
		newObj.setName(obj.getName());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete because there are related entities.");
		}
	}
	
	public List<Planet> findAll() {
		return repo.findAll();
	}
	
	public Page<Planet> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Planet fromDTO(PlanetDto objDto) {
		return new Planet(objDto.getId(), objDto.getName(), objDto.getMovieAppearances());
	}
	
}
