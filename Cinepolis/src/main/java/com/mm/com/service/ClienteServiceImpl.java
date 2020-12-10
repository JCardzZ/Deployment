package com.mm.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mm.com.model.Cliente;
import com.mm.com.model.Genero;
import com.mm.com.model.Producto;
import com.mm.com.model.Tiket;
import com.mm.com.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepository clienteDao;

	@Autowired
	private IProductoDao productoDao;

	@Autowired
	private ITiketDao tiketDao;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Cliente fetchByIdWithTikets(Long id) {
		return clienteDao.fetchByIdWithTiket(id);
	}


	@Override
	public void detele(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	public Page<Cliente> searchAlls(Pageable page) {
		return clienteDao.findAll(page);
	}

	@Override
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%" + term + "%");
	}

	@Override
	@Transactional
	public void saveTiket(Tiket tiket) {
		tiketDao.save(tiket);
	}

	@Override
	@Transactional
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Tiket findByTiketById(Long id) {
		return tiketDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteTiket(Long id) {
		tiketDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Tiket fetchTiketByIdWithClienteWhithItemTiketWithProducto(Long id) {
		return tiketDao.fetchByIdWithClienteWhithItemTiketWithProducto(id);
	}


}
