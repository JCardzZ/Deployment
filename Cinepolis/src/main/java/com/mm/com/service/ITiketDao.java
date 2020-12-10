package com.mm.com.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mm.com.model.Tiket;

public interface ITiketDao  extends CrudRepository<Tiket, Long>{

	@Query("select t from Tiket t join fetch t.cliente c join fetch t.items l join fetch l.producto where t.id=?1")
	public Tiket fetchByIdWithClienteWhithItemTiketWithProducto(Long id);
}
