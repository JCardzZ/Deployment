package com.mm.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mm.com.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

}
