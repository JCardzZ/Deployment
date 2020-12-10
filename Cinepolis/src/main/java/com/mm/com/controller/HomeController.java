package com.mm.com.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.mm.com.model.Pelicula;
import com.mm.com.service.IGeneroService;
import com.mm.com.service.IPeliculaService;

@Controller
public class HomeController {

	@Autowired
	private IPeliculaService servicePelicula;

	@Autowired
	private IGeneroService seriveGenero;

	@GetMapping("/cartel")
	public String xd() {
		return "cartel";
	}

	@GetMapping("/")
	public String mostrarCine(Model model) {
		return "index";
	}

	@GetMapping("/cartelera")
	public String mostrarCartelera(Model model) {
		return "FormCartelera";
	}

	@ModelAttribute
	public void setGenerics(Model model) {
		Pelicula peliculasearch = new Pelicula();
		peliculasearch.resetPelicula();
		model.addAttribute("peliculas", servicePelicula.buscarPeliculaDestaca());
		model.addAttribute("generos", seriveGenero.searchAll());
		model.addAttribute("search", peliculasearch);

	}

	@GetMapping("/detalle/{id}")
	public String mostrarDetallePeliculas(Model model) {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("Los nuevos mutantes");
		pelicula.setIdioma("Español");
		pelicula.setDuracion("123");
		pelicula.setClasificacion("B");
		pelicula.setSubtitulos("Si");
		pelicula.setFechaEstreno(new Date());
		model.addAttribute("pelicula", pelicula);
		return "detalle";
	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<>();
		lista.add("Rapido y furioso");
		lista.add("La Bella y la Bestia");
		lista.add("It");
		lista.add("Scooby Doo");

		model.addAttribute("peliculas", lista);
		return "listado";

	}

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Pelicula> lista = servicePelicula.searchAll();
		model.addAttribute("vacantes", lista);

		return "tabla";
	}

	@GetMapping("/detalle{id}")
	public String index(Model model, @PathVariable("id") int idPelicula) {

		System.out.println("idPelicula:" + idPelicula);

		String nombre = "Rapido y furioso";
		Date fechaPub = new Date();
		double precio = 900.00;
		boolean vigente = true;

		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("precio", precio);
		model.addAttribute("vigente", vigente);

		return "inicio";
	}

	@GetMapping("/search")
	public String buscarPelicula(@ModelAttribute("search") Pelicula pelicula, Model model) {
		System.out.println("Buscando por :" + pelicula);

//		// Personalizamos el tipo de busqueda...
		ExampleMatcher matcher = ExampleMatcher.matching().
		// and descripcion like '%?%'
				withMatcher("titulo", ExampleMatcher.GenericPropertyMatchers.contains());

		Example<Pelicula> example = Example.of(pelicula, matcher);
		List<Pelicula> lista = servicePelicula.buscarByExample(example);
		model.addAttribute("peliculas", lista);
		return "cartel";
	}


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

}
