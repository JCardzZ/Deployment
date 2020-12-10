package com.mm.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mm.com.model.Producto;

@Service
public interface ProductoRepository  extends JpaRepository<Producto, Long>{

}
