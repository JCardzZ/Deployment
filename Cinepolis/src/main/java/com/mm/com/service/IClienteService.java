package com.mm.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mm.com.model.Cliente;
import com.mm.com.model.Genero;
import com.mm.com.model.Producto;
import com.mm.com.model.Tiket;

public interface IClienteService {

	public List<Cliente> findAll();
	
	Page<Cliente> searchAlls(Pageable page);

	public void save(Cliente cliente);

	public Cliente findOne(Long id);
	
	public Cliente fetchByIdWithTikets(Long id);

	public void detele(Long id);

	public List<Producto> findByNombre(String term);
	
	public void saveTiket(Tiket tiket);
	
	public Producto findProductoById(Long id);
	
	public Tiket findByTiketById(Long id);
	
	public void deleteTiket(Long id);
	
	public Tiket fetchTiketByIdWithClienteWhithItemTiketWithProducto(Long id);
	
	
}
