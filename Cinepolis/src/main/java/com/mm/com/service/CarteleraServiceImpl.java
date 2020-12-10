package com.mm.com.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mm.com.model.Cartelera;

@Service
public class CarteleraServiceImpl implements ICarteleraService {

	private List<Cartelera> lista = null;

	public CarteleraServiceImpl() {
		lista = new LinkedList<Cartelera>();

		Cartelera cat1 = new Cartelera();
		cat1.setId(1);
		cat1.setTitulo("Cartelera 1");
		cat1.setArchivo("x.jpg");
		cat1.setEstado("Activa");

		Cartelera cat2 = new Cartelera();
		cat2.setId(2);
		cat2.setTitulo("Cartelera 2");
		cat2.setArchivo("x.jpg");
		cat2.setEstado("Activa");

		Cartelera cat3 = new Cartelera();
		cat3.setId(3);
		cat3.setTitulo("Cartelera 3");
		cat3.setArchivo("x.jpg");
		cat3.setEstado("Activa");

		Cartelera cat4 = new Cartelera();
		cat4.setId(4);
		cat4.setTitulo("Cartelera 4");
		cat4.setArchivo("x.jpg");
		cat4.setEstado("Activa");

		Cartelera cat5 = new Cartelera();
		cat5.setId(5);
		cat5.setTitulo("Cartelera 5");
		cat5.setArchivo("x.jpg");
		cat5.setEstado("Activa");

		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		lista.add(cat5);

	}

	public void guardar(Cartelera cartelera) {
		lista.add(cartelera);
	}

	public List<Cartelera> buscarTodas() {
		return lista;
	}

	public Cartelera buscarPorId(Integer idCartelera) {
		for (Cartelera cat : lista) {
			if (cat.getId() == idCartelera) {
				return cat;
			}
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCartelera) {
		// TODO Auto-generated method stub
		
	}

}
