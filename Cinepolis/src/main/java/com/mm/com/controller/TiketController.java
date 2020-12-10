package com.mm.com.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mm.com.model.Cliente;
import com.mm.com.model.Compra;
import com.mm.com.model.Producto;
import com.mm.com.model.Tiket;
import com.mm.com.service.ClienteServiceImpl;
import com.mm.com.service.IClienteService;

@Controller
@RequestMapping("/tiket")
@SessionAttributes("tiket")
public class TiketController {

	@Autowired
	private IClienteService clienteService;

	private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Tiket tiket = clienteService.fetchTiketByIdWithClienteWhithItemTiketWithProducto(id);

		if (tiket == null) {
			flash.addFlashAttribute("error", "¡El Tiket no existe en la base de datos!");
			return "redirect:/listar";
		}
		model.addAttribute("tiket", tiket);
		model.addAttribute("titulo", "Tiket: ".concat(tiket.getDescripcion()));
		return "tiket/ver";
	}

	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
			RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(clienteId);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		Tiket tiket = new Tiket();
		tiket.setCliente(cliente);

		model.put("tiket", tiket);
		model.put("titulo", "Crear Tiket");

		return "tiket/form";
	}

	@GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
		return clienteService.findByNombre(term);
	}

	@PostMapping("/form")
	public String guardarTiket(@Valid Tiket tiket, BindingResult result, Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash,
			SessionStatus status) {

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = clienteService.findProductoById(itemId[i]);

			Compra compra = new Compra();
			compra.setCantidad(cantidad[i]);
			compra.setProducto(producto);
			tiket.addItemTiket(compra);

			log.info("ID: " + itemId.toString() + ", cantidad: " + cantidad[i].toString());

		}
		clienteService.saveTiket(tiket);
		status.setComplete();

		flash.addFlashAttribute("success", "¡Tiket creado con éxito!");

		return "redirect:/clientes/ver/" + tiket.getCliente().getId();
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarTiket(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		Tiket tiket = clienteService.findByTiketById(id);

		if (tiket != null) {
			clienteService.deleteTiket(id);
			flash.addFlashAttribute("success", "¡Tiket eliminado con éxito!");
			return "redirect:/clientes/ver/" + tiket.getCliente().getId();

		}
		flash.addFlashAttribute("error",
				"¡El Tiket no existe en la base de datos, por lo tanto es imposible eliminar!");
		return "redirect:/clientes/listar";
	}
}
