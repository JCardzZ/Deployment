package com.mm.com.service;

import java.util.List;

import com.mm.com.model.Cartelera;

public interface ICarteleraService {
	void guardar(Cartelera cartelera);
	List<Cartelera> buscarTodas();
	Cartelera buscarPorId(Integer idCartelera);	
	void eliminar(Integer idCartelera);

}

