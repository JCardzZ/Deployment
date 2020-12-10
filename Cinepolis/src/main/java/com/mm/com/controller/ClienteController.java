package com.mm.com.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.naming.spi.DirStateFactory.Result;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mm.com.model.Cliente;
import com.mm.com.model.Genero;
import com.mm.com.repository.ClienteRepository;
import com.mm.com.service.IClienteService;

@Controller
@SessionAttributes("cliente")
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	private final static String FOTOS_CLIENTES = "clientes";

	private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = clienteService.fetchByIdWithTikets(id);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		model.put("cliente", cliente);
		model.put("titulo", "Detalle cliente: " + cliente.getNombre());
		return "ver";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}

	@GetMapping("/form")
	public String crearCliente(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "clientes/form";
	}

	@PostMapping("/form")
	public String guardarCliente(Cliente cliente, @RequestParam("file") MultipartFile foto, RedirectAttributes flash,
			SessionStatus status) {
		String msgFlash = (cliente.getId() != null) ? "¡Cliente editado con éxito!" : "¡Cliente creado con éxito!";

		if (!foto.isEmpty()) {

			if (cliente.getId() != null && cliente.getId() > 0 && cliente.getFoto() != null
					&& cliente.getFoto().length() > 0) {

				Path rootPath = Paths.get(FOTOS_CLIENTES).resolve(cliente.getFoto()).toAbsolutePath();
				File archivo = rootPath.toFile();

				if (archivo.exists() && archivo.canRead()) {
					if (archivo.delete()) {
					}
				}
			}

			String uniqueFileName = UUID.randomUUID().toString() + "-" + foto.getOriginalFilename();
			Path rootPath = Paths.get(FOTOS_CLIENTES).resolve(uniqueFileName);

			Path rootAbsoluPath = rootPath.toAbsolutePath();
			log.info("rootPath: " + rootPath);
			log.info("rootAbsolutePath: " + rootAbsoluPath);

			try {
				Files.copy(foto.getInputStream(), rootAbsoluPath);

				flash.addFlashAttribute("info", "¡Has agregado con éxito la foto de perfil " + cliente.getNombre() + "!");
				cliente.setFoto(uniqueFileName);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		clienteService.save(cliente);
		flash.addFlashAttribute("success", msgFlash);
		return "redirect:/clientes/indexPaginate";

	}

	@GetMapping("/form/{id}")
	public String editarCliente(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {
		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);
			if (cliente == null) {
				flash.addFlashAttribute("error", "¡El ID del cliente no existe en la base de datos!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "¡El ID del cliente no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "clientes/form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarCliente(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			Cliente cliente = clienteService.findOne(id);

			clienteService.detele(id);
			flash.addFlashAttribute("info", "¡Cliente eliminado con éxito!");

			Path rootPath = Paths.get(FOTOS_CLIENTES).resolve(cliente.getFoto()).toAbsolutePath();
			File archivo = rootPath.toFile();

			if (archivo.exists() && archivo.canRead()) {
				if (archivo.delete()) {
				}

			}

		}
		return "redirect:/clientes/indexPaginate";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Cliente> lista = clienteService.searchAlls(page);
		model.addAttribute("clientes", lista);
		return "clientes/listar";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
