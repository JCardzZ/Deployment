package com.mm.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.com.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

	List<Pelicula> findByEstatus(String estatus);
	List<Pelicula> findByDestacadaAndEstatusOrderByIdDesc(int destacada, String estatus);
	List<Pelicula> findByPrecioBetweenOrderByPrecioDesc(double p1, double p2);
	List<Pelicula> findByEstatusIn(String[] estatus);
}
