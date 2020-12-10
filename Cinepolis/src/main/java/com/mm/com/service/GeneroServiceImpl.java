package com.mm.com.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mm.com.model.Genero;

@Service
//@Primary
public class GeneroServiceImpl implements IGeneroService {

	private List<Genero> lista = null;

	public GeneroServiceImpl() {
		lista = new LinkedList<Genero>();


		Genero cat1 = new Genero();
		cat1.setId(1);
		cat1.setNombre("Contabilidad");
		cat1.setDescripcion("Descripcion de la categoria Contabilidad");

		Genero cat2 = new Genero();
		cat2.setId(2);
		cat2.setNombre("Ventas");
		cat2.setDescripcion("Trabajos relacionados con Ventas");

		Genero cat3 = new Genero();
		cat3.setId(3);
		cat3.setNombre("Comunicaciones");
		cat3.setDescripcion("Trabajos relacionados con Comunicaciones");

		Genero cat4 = new Genero();
		cat4.setId(4);
		cat4.setNombre("Arquitectura");
		cat4.setDescripcion("Trabajos de Arquitectura");

		Genero cat5 = new Genero();
		cat5.setId(5);
		cat5.setNombre("Educacion");
		cat5.setDescripcion("Maestros, tutores, etc");

		/**
		 * Agregamos los 5 objetos de tipo Categoria a la lista ...
		 */
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		lista.add(cat5);

	}

	public void guardar(Genero genero) {
		lista.add(genero);
	}

	public List<Genero> searchAll() {
		return lista;
	}

	public Genero buscarPorId(Integer idCategoria) {
		for (Genero cat : lista) {
			if (cat.getId() == idCategoria) {
				return cat;
			}
		}
		return null;
	}

	@Override
	public void deleteGenero(Integer idGenero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Genero> searchAlls(Pageable page) {
		return null;
	}


}
