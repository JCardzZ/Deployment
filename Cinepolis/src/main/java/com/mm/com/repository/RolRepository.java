package com.mm.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mm.com.model.Role;

@Repository
public interface RolRepository extends CrudRepository<Role,Long>{

	public Role findByName(String name);
}
