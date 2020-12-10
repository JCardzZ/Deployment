package com.mm.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mm.com.model.Cartelera;
import com.mm.com.model.Noticia;
import com.mm.com.service.ICarteleraService;
import com.mm.com.util.Utileria;

@Controller
@RequestMapping("/cartelera")
public class CarteleraController {
	
	@Value("${cinepolis.ruta.imagenes}")
//	@Value("${cinepolis2.ruta2.imagenes2}")
	private String ruta;

	@Autowired
	private ICarteleraService serviceCartelera;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Cartelera> lista = serviceCartelera.buscarTodas();
		model.addAttribute("carteleras", lista);
		return "cartelera/listCartelera";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crear(Cartelera cartelera) {
		return "cartelera/formCarterela";
	}


	@PostMapping("/save")
	public String guardarNoticia(Cartelera cartelera, RedirectAttributes flash,
			@RequestParam("archivoImagen") MultipartFile multiPart, BindingResult result) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "cartelera/formCartelera";
		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) {
				cartelera.setArchivo(nombreImagen);
			}
		}

		serviceCartelera.guardar(cartelera);
		flash.addFlashAttribute("msg", "¡Cartelera almacenada con éxito!");
		System.out.println("Cartelera: " + cartelera);
		return "redirect:/cartelera/index";

	}

	@GetMapping("/edit/{id}")
	public String editarNoticia(@PathVariable("id") int idCartelera, Model model) {
		Cartelera noticia = serviceCartelera.buscarPorId(idCartelera);
		model.addAttribute("cartelera", noticia);
		return "cartelera/formCarterela";

	}

	@GetMapping("/delete/{id}")
	public String eliminarCartelera(@PathVariable("id") int idCartelera, Model model, RedirectAttributes flash) {
		System.out.println("Borrando noticia con id: " + idCartelera);

		serviceCartelera.eliminar(idCartelera);
		flash.addFlashAttribute("msg", "¡Cartelera eliminada con éxito!");
		return "redirect:/cartelera/index";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
