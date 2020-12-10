package com.mm.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.com.model.Funcion;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long>{

}
