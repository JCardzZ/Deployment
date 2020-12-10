package com.mm.com.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mm.com.model.Genero;
import com.mm.com.service.IGeneroService;


@Controller
@RequestMapping(value="/generos")
public class GeneroController {
	
	@Autowired
   	private IGeneroService serviceGeneros;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Genero> lista = serviceGeneros.searchAll();
    	model.addAttribute("generos", lista);
		return "generos/listGeneros";		
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Genero genero) {
		return "generos/formGenero";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Genero genero, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "generos/formGenero";
		}	
		
		serviceGeneros.guardar(genero);
		attributes.addFlashAttribute("msg", "¡Los datos del genero fueron guardados!");		
		return "redirect:/generos/indexPaginate";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idGenero, Model model) {		
		Genero genero = serviceGeneros.buscarPorId(idGenero);			
		model.addAttribute("genero", genero);
		return "generos/formGenero";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idGenero, RedirectAttributes attributes) {		
		serviceGeneros.deleteGenero(idGenero);			
		attributes.addFlashAttribute("msg", "¡El genero fue eliminado con éxito!");
		return "redirect:/generos/indexPaginate";
	}
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Genero> lista = serviceGeneros.searchAlls(page);
		model.addAttribute("generos", lista);
		return "generos/listGeneros";
	}

}
