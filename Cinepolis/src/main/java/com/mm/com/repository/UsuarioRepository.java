package com.mm.com.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mm.com.model.User;

@Repository
public interface UsuarioRepository extends CrudRepository<User, Long> {

	public Optional<User> findByUsername(String username);
	
}
