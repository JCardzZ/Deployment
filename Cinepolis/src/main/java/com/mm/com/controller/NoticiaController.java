package com.mm.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.bouncycastle.math.raw.Mod;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mm.com.model.Noticia;
import com.mm.com.model.Pelicula;
import com.mm.com.service.INoticiaService;
import com.mm.com.util.Utileria;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {

	@Value("${cinepolis1.ruta1.imagenes1}")
	private String ruta;

	@Autowired
	private INoticiaService serviceNoticias;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Noticia> lista = serviceNoticias.buscarTodasNoticias();
		model.addAttribute("noticias", lista);
		return "noticias/listNoticias";
	}

	@GetMapping("/create")
	public String crearNoticia(Noticia noticia, Model model) {
		model.addAttribute("noticias", serviceNoticias.buscarTodasNoticias());
		return "noticias/formNoticia";
	}

	@PostMapping("/save")
	public String guardarNoticia(Noticia noticia, RedirectAttributes flash,
			@RequestParam("archivoImagen") MultipartFile multiPart, BindingResult result) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "noticias/formNoticia";
		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) {
				noticia.setImagenNoticia(nombreImagen);
			}
		}

		serviceNoticias.guardarNoticia(noticia);
		flash.addFlashAttribute("msg", "¡Noticia almacenada con éxito!");
		System.out.println("Noticia: " + noticia);
		return "redirect:/noticias/index";

	}

	@GetMapping("/delete/{id}")
	public String eliminarNoticia(@PathVariable("id") int idNoticia, Model model, RedirectAttributes flash) {
		System.out.println("Borrando noticia con id: " + idNoticia);

		serviceNoticias.eliminar(idNoticia);
		flash.addFlashAttribute("msg", "¡Noticia eliminada con éxito!");
		return "redirect:/noticias/index";
	}

	@GetMapping("/edit/{id}")
	public String editarNoticia(@PathVariable("id") int idNoticia, Model model) {
		Noticia noticia = serviceNoticias.buscarPorId(idNoticia);
		model.addAttribute("noticias", noticia);
		return "noticias/formNoticia";

	}

	@GetMapping("/view/{id}")
	public String verDetalleNoticia(@PathVariable("id") int idNoticia, Model model) {

		Noticia noticia = serviceNoticias.buscarPorId(idNoticia);
		System.out.println("IdNoticia: " + idNoticia);
		model.addAttribute("noticias", noticia);
		return "detalleNoticia";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
