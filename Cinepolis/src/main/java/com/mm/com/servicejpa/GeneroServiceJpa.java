package com.mm.com.servicejpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mm.com.model.Genero;
import com.mm.com.repository.GeneroRepository;
import com.mm.com.service.IGeneroService;

@Service
@Primary
public class GeneroServiceJpa implements IGeneroService {

	@Autowired
	private GeneroRepository generoRepository;

	@Override
	public void guardar(Genero genero) {
		generoRepository.save(genero);
	}

	@Override
	public List<Genero> searchAll() {
		return generoRepository.findAll();
	}

	@Override
	public Genero buscarPorId(Integer idGenero) {
		Optional<Genero> optional = generoRepository.findById(idGenero);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteGenero(Integer idGenero) {
		generoRepository.deleteById(idGenero);
	}

	@Override
	public Page<Genero> searchAlls(Pageable page) {
		return generoRepository.findAll(page);

	}

}
