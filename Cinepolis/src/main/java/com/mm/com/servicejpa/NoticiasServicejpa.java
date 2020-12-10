package com.mm.com.servicejpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mm.com.model.Noticia;
import com.mm.com.repository.NoticiaRepository;
import com.mm.com.service.INoticiaService;

@Service
@Primary
public class NoticiasServicejpa implements INoticiaService {

	@Autowired
	private NoticiaRepository noticiasRepo;

	@Override
	public List<Noticia> buscarTodasNoticias() {
		return noticiasRepo.findAll();
	}

	@Override
	public Noticia buscarPorId(Integer idNoticia) {
		Optional<Noticia> optional = noticiasRepo.findById(idNoticia);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardarNoticia(Noticia noticia) {
		noticiasRepo.save(noticia);
	}

	@Override
	public List<Noticia> buscarEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idNoticia) {
noticiasRepo.deleteById(idNoticia);
	}

}
