package com.mm.com;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.mm.com.model.Cartelera;
import com.mm.com.model.Noticia;
import com.mm.com.repository.CarteleraRepository;
import com.mm.com.repository.NoticiaRepository;

@SpringBootApplication
public class CinepolisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinepolisApplication.class, args);
	}

}
