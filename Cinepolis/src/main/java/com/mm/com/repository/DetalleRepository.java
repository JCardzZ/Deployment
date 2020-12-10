package com.mm.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.com.model.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {

}
