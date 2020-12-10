package com.mm.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.com.model.Tiket;

@Repository
public interface TiketRepository extends JpaRepository<Tiket, Long>{

}
 