package com.mm.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mm.com.model.Genero;

public interface IGeneroService {
	
	void guardar(Genero genero);

	List<Genero> searchAll();

	Genero buscarPorId(Integer idGenero);

	void deleteGenero(Integer idGenero);

	Page<Genero> searchAlls(Pageable page);

}
