package com.mm.com.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mm.com.model.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	private List<Pelicula> lista = null;

	public PeliculaServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Pelicula>();

		try {
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("El convento");
			pelicula1.setIdioma("Español");
			pelicula1.setDuracion("195");
			pelicula1.setClasificacion("B");
			pelicula1.setSubtitulos("Si");
			pelicula1.setPrecio(1.50);
			pelicula1.setFechaEstreno(sdf.parse("09-02-2020"));
			pelicula1.setDestacada(0);
			pelicula1.setImagen("convento.jpg");

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Epoca");
			pelicula2.setIdioma("Español");
			pelicula2.setDuracion("132");
			pelicula2.setClasificacion("B");
			pelicula2.setSubtitulos("Si");
			pelicula2.setPrecio(4.50);
			pelicula2.setFechaEstreno(sdf.parse("09-02-2020"));
			pelicula2.setDestacada(1);
			pelicula2.setImagen("epoca.jpg");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Isla");
			pelicula3.setIdioma("Ingles");
			pelicula3.setDuracion("110");
			pelicula3.setClasificacion("C");
			pelicula3.setSubtitulos("No");
			pelicula3.setPrecio(3.50);
			pelicula3.setFechaEstreno(sdf.parse("05-01-2020"));
			pelicula3.setDestacada(1);
			pelicula3.setImagen("isla.jpg");

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("King Kong");
			pelicula4.setIdioma("Ruso");
			pelicula4.setDuracion("100");
			pelicula4.setClasificacion("A");
			pelicula4.setSubtitulos("No");
			pelicula4.setPrecio(5.50);
			pelicula4.setFechaEstreno(sdf.parse("09-02-2019"));
			pelicula4.setDestacada(0);
			pelicula4.setImagen("mutantes.jpg");

			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("La bella y la bestia");
			pelicula5.setIdioma("Chino");
			pelicula5.setDuracion("100");
			pelicula5.setClasificacion("C");
			pelicula5.setSubtitulos("Si");
			pelicula5.setPrecio(5.50);
			pelicula5.setFechaEstreno(sdf.parse("09-02-2020"));
			pelicula5.setDestacada(5);
			pelicula5.setImagen("tenet.jpg");
			
			

			Pelicula pelicula6 = new Pelicula();
			pelicula6.setId(6);
			pelicula6.setTitulo("Choki");
			pelicula6.setIdioma("Español");
			pelicula6.setDuracion("100");
			pelicula6.setClasificacion("C");
			pelicula6.setSubtitulos("Si");
			pelicula6.setPrecio(2.50);
			pelicula6.setFechaEstreno(sdf.parse("09-02-2020"));
			pelicula6.setDestacada(5);
			pelicula6.setImagen("tenet.jpg");
			

			Pelicula pelicula7 = new Pelicula();
			pelicula7.setId(7);
			pelicula7.setTitulo("Inmortales");
			pelicula7.setIdioma("Chino");
			pelicula7.setDuracion("100");
			pelicula7.setClasificacion("C");
			pelicula7.setSubtitulos("Si");
			pelicula1.setPrecio(2.75);
			pelicula7.setFechaEstreno(sdf.parse("09-02-2020"));
			pelicula7.setDestacada(5);
			pelicula7.setImagen("gato.png");
			

			Pelicula pelicula8 = new Pelicula();
			pelicula8.setId(8);
			pelicula8.setTitulo("Los Verduleros");
			pelicula8.setIdioma("Chino");
			pelicula8.setDuracion("100");
			pelicula8.setClasificacion("C");
			pelicula8.setSubtitulos("Si");
			pelicula1.setPrecio(1.75);
			pelicula8.setFechaEstreno(sdf.parse("09-02-2020"));
			pelicula8.setDestacada(5);
			pelicula8.setImagen("espia.jpg");

			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
			lista.add(pelicula6);
			lista.add(pelicula7);
			lista.add(pelicula8);


		} catch (Exception e) {
			System.out.println("Error en: " + e.getMessage());

		}
	}

	@Override
	public List<Pelicula> searchAll() {
		return lista;
	}



	@Override
	public Pelicula searchById(Integer idPelicula) {
		for (Pelicula p: lista) {
			if (p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void save(Pelicula pelicula) {

		lista.add(pelicula);
	}

	@Override
	public List<Pelicula> buscarPeliculaDestaca() {
		return null;
	}

	@Override
	public void deletePelicula(Integer idPelicula) {
		
	}

	@Override
	public List<Pelicula> buscarByExample(Example<Pelicula> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Pelicula> searchAlls(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}



}
