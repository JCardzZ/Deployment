package com.mm.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mm.com.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select c from Cliente c left join fetch c.tikets t where c.id=?1")
	public Cliente fetchByIdWithTiket(Long id);
}
