package com.mm.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mm.com.model.Noticia;
import com.mm.com.service.INoticiaService;

@Controller
//@RequestMapping("/noticias")
public class HomeNoticiaController {

	@Autowired
	private INoticiaService serviceNoticias;

	@GetMapping("/view/{id}")
	public String verDetalleNoticia(@PathVariable("id") int idNoticia, Model model) {
		System.out.println("IdNoticia: " + idNoticia);
		model.addAttribute("idNoticia", idNoticia);
		return "noticias/detalle";
	}

	@GetMapping("/tablaNoticias")
	public String mostrarTabla(Model model) {
		List<Noticia> lista = serviceNoticias.buscarTodasNoticias();
		model.addAttribute("noticias", lista);

		return "tablaNoticias";
	}

	@GetMapping("/detalleNoticia")
	public String mostrarDetalleNoticia(Model model) {
		Noticia noticia = new Noticia();

		noticia.setTituloGrande("TITULO GRANDE");
		noticia.setDescripcionPeque("DESCRIPCION PEQUEÑA");
		noticia.setTituloGrandeTendencia("TITULO GRANDE TENDENCIA");
		noticia.setDescripcionpeqtend("TITULO PEQUEÑO TENDENCIA");
		noticia.setTituloGrande("TITULO GRANDE");
		noticia.setTituloGrandeNumeros("TITULO GRANDE NUMEROS");
		noticia.setDescripcionNumeros("DESCRIPCION NUMEROS");
		noticia.setTituloGrandeApp("TITULO GRANDE APP");
		noticia.setDescripcionPequeaApp(" DESCRIPCION PEQUEÑA APP");
		noticia.setFecha(new Date());
		noticia.setDetalle("DETALLE");

		model.addAttribute("noticia", noticia);
		return "detalleNoticia";

	}

	@GetMapping("/listNoticias")
	public String mostrarListaNoticias(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Noticias de Septiembre de 2020");
		lista.add("Noticias de Octubre de 2020");
		lista.add("Noticias de Noviembre de 2020");
		lista.add("Noticias de Diciembre de 2020");
		lista.add("Noticias de Enero de 2021");

		model.addAttribute("noticias", lista);

		return "listNoticias";

	}

}
