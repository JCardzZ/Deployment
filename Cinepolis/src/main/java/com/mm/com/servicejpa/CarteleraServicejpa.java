package com.mm.com.servicejpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mm.com.model.Cartelera;
import com.mm.com.repository.CarteleraRepository;
import com.mm.com.service.ICarteleraService;

@Service
@Primary
public class CarteleraServicejpa implements ICarteleraService {

	@Autowired
	private CarteleraRepository carteleraRepository;

	@Override
	public void guardar(Cartelera cartelera) {
		carteleraRepository.save(cartelera);
	}

	@Override
	public List<Cartelera> buscarTodas() {
		return carteleraRepository.findAll();
	}

	@Override
	public Cartelera buscarPorId(Integer idCartelera) {
		Optional<Cartelera> optional = carteleraRepository.findById(idCartelera);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCartelera) {
		carteleraRepository.deleteById(idCartelera);
	}

}
