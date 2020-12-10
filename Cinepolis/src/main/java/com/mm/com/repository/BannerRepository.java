package com.mm.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.com.model.Cartelera;

@Repository
public interface BannerRepository extends JpaRepository<Cartelera, Long>{

}
