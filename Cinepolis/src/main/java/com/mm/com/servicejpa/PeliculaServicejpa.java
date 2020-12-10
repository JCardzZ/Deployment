package com.mm.com.servicejpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mm.com.model.Pelicula;
import com.mm.com.repository.PeliculaRepository;
import com.mm.com.service.IPeliculaService;

@Service
@Primary
public class PeliculaServicejpa implements IPeliculaService{

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Override
	public List<Pelicula> searchAll() {
		return peliculaRepository.findAll();
	}


	@Override
	public Pelicula searchById(Integer idPelicula) {
		Optional<Pelicula> optional = peliculaRepository.findById(idPelicula);
		if(optional.isPresent()) {
		return optional.get();
		}
		return null;
	}

	@Override
	public void save(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
	}



	@Override
	public List<Pelicula> buscarPeliculaDestaca() {
		return peliculaRepository.findByDestacadaAndEstatusOrderByIdDesc(1, "Aprobada");
	}



	@Override
	public void deletePelicula(Integer idPelicula) {
		peliculaRepository.deleteById(idPelicula);
	}


	@Override
	public List<Pelicula> buscarByExample(Example<Pelicula> example) {
		return peliculaRepository.findAll(example);
	}


	@Override
	public Page<Pelicula> searchAlls(Pageable page) {
		return peliculaRepository.findAll(page);
	}


	

}
