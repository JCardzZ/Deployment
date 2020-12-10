package com.mm.com.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mm.com.model.Pelicula;

public interface IPeliculaService {

	List<Pelicula> searchAll();

	Pelicula searchById(Integer idPelicula);

	void save(Pelicula pelicula);

	List<Pelicula> buscarPeliculaDestaca();
	
	void deletePelicula(Integer idPelicula);
	
	List<Pelicula> buscarByExample(Example<Pelicula> example);
	
	Page<Pelicula> searchAlls(Pageable page);
	
}
