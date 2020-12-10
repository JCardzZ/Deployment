package com.mm.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mm.com.model.Pelicula;
import com.mm.com.service.IGeneroService;
import com.mm.com.service.IPeliculaService;
import com.mm.com.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

	@Value("${cinepolis.ruta.imagenes}")
	private String ruta;

	@Autowired
	private IPeliculaService servicePelicula;

	@Autowired
	private IGeneroService serviceGenero;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePelicula.searchAll();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}

	@GetMapping("/create")
	public String crearPelicula(Pelicula pelicula, Model model) {
		return "peliculas/formPelicula";
	}

	@ModelAttribute
	public void setGenerics(Model model) {
		model.addAttribute("generos", serviceGenero.searchAll());
	}

	@PostMapping("/save")
	public String guardarPelicula(Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "peliculas/formPelicula";
//			return "redirect:/peliculas/indexPaginate";


		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) {
				pelicula.setImagen(nombreImagen);
			}
		}

		servicePelicula.save(pelicula);
		attributes.addFlashAttribute("msg", "¡Pelicula almacenada con éxito!");
//		System.out.println("Pelicula: " + pelicula);
		return "redirect:/peliculas/indexPaginate";

	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula, Model model, RedirectAttributes attributes) {
		System.out.println("Borrando pelicula con id: " + idPelicula);
		servicePelicula.deletePelicula(idPelicula);
		attributes.addFlashAttribute("msg", "¡Pelicula eliminada con éxito!");
		model.addAttribute("id", idPelicula);
		return "redirect:/peliculas/indexPaginate";
	}

	@GetMapping("/edit/{id}")
	public String editarPelicula(@PathVariable("id") int idPelicula, Model model) {
		Pelicula pelicula = servicePelicula.searchById(idPelicula);
		model.addAttribute("pelicula", pelicula);
		return "peliculas/formPelicula";

	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idPelicula, Model model) {

		Pelicula pelicula = servicePelicula.searchById(idPelicula);

		System.out.println("Pelicula: " + pelicula);
		model.addAttribute("pelicula", pelicula);
		return "detalle";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = servicePelicula.searchAlls(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}

	
}
