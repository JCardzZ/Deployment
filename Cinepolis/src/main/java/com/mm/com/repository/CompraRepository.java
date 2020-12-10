package com.mm.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.com.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
