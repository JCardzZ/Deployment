package com.mm.com.service;

import java.util.List;

import com.mm.com.model.Noticia;

public interface INoticiaService {

	List<Noticia> buscarTodasNoticias();

	Noticia buscarPorId(Integer idNoticia);
	
	void guardarNoticia(Noticia noticia);
	
	List<Noticia> buscarEstado();
	
	void eliminar(Integer idNoticia);
}
