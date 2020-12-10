package com.mm.com.service;

import java.net.IDN;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mm.com.model.Noticia;

@Service
//@Primary
public class NoticiasServicesImpl implements INoticiaService {

	private List<Noticia> lista = null;

	public NoticiasServicesImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		lista = new LinkedList<Noticia>();
		try {
			Noticia noticia1 = new Noticia();
			noticia1.setId(1);
			noticia1.setTituloGrande("TITULO GRANDE 1 OOKKKKK");
			noticia1.setDescripcionPeque("DESCRIPCION PEQUEÑA 1");
			noticia1.setTituloGrandeTendencia("TITULO GRANDE TENDENCIA 1");
			noticia1.setDescripcionpeqtend("TITULO PEQUEÑO TENDENCIA 1");
			noticia1.setTituloGrande("TITULO GRANDE 1");
			noticia1.setTituloGrandeNumeros("TITULO GRANDE NUMEROS 1");
			noticia1.setDescripcionNumeros("DESCRIPCION NUMEROS 1");
			noticia1.setTituloGrandeApp("TITULO GRANDE APP 1");
			noticia1.setDescripcionPequeaApp(" DESCRIPCION PEQUEÑA APP 1");
			noticia1.setFecha(new Date());
			noticia1.setEstado("Activa");
			noticia1.setImagenNoticia("x.jpg");

			Noticia noticia2 = new Noticia();
			noticia2.setId(2);
			noticia2.setTituloGrande("TITULO GRANDE 2");
			noticia2.setDescripcionPeque("DESCRIPCION PEQUEÑA 2");
			noticia2.setTituloGrandeTendencia("TITULO GRANDE TENDENCIA 2");
			noticia2.setDescripcionpeqtend("TITULO PEQUEÑO TENDENCIA 2");
			noticia2.setTituloGrande("TITULO GRANDE 2");
			noticia2.setTituloGrandeNumeros("TITULO GRANDE NUMEROS 2");
			noticia2.setDescripcionNumeros("DESCRIPCION NUMEROS 2");
			noticia2.setTituloGrandeApp("TITULO GRANDE APP 2");
			noticia2.setDescripcionPequeaApp(" DESCRIPCION PEQUEÑA APP 2");
			noticia2.setFecha(new Date());
			noticia2.setEstado("Activa");
			noticia2.setImagenNoticia("transilvania.jpg");

			Noticia noticia3 = new Noticia();
			noticia3.setId(3);
			noticia3.setTituloGrande("TITULO GRANDE 3");
			noticia3.setDescripcionPeque("DESCRIPCION PEQUEÑA 3");
			noticia3.setTituloGrandeTendencia("TITULO GRANDE TENDENCIA 3");
			noticia3.setDescripcionpeqtend("TITULO PEQUEÑO TENDENCIA 3");
			noticia3.setTituloGrande("TITULO GRANDE 3");
			noticia3.setTituloGrandeNumeros("TITULO GRANDE NUMEROS 3");
			noticia3.setDescripcionNumeros("DESCRIPCION NUMEROS 3");
			noticia3.setTituloGrandeApp("TITULO GRANDE APP 3");
			noticia3.setDescripcionPequeaApp(" DESCRIPCION PEQUEÑA APP 3");
			noticia3.setFecha(new Date());
			noticia3.setEstado("Activa");
			noticia3.setImagenNoticia("tenet.jpg");

			Noticia noticia4 = new Noticia();
			noticia4.setId(4);
			noticia4.setTituloGrande("TITULO GRANDE 44444444444444444444");
			noticia4.setDescripcionPeque("DESCRIPCION PEQUEÑA 4");
			noticia4.setTituloGrandeTendencia("TITULO GRANDE TENDENCIA 4");
			noticia4.setDescripcionpeqtend("TITULO PEQUEÑO TENDENCIA 4");
			noticia4.setTituloGrande("TITULO GRANDE 4");
			noticia4.setTituloGrandeNumeros("TITULO GRANDE NUMEROS 4");
			noticia4.setDescripcionNumeros("DESCRIPCION NUMEROS 4");
			noticia4.setTituloGrandeApp("TITULO GRANDE APP 4");
			noticia4.setDescripcionPequeaApp(" DESCRIPCION PEQUEÑA APP 4");
			noticia4.setFecha(new Date());
			noticia4.setEstado("Activa");
			noticia4.setImagenNoticia("raton.png");

			lista.add(noticia1);
			lista.add(noticia2);
			lista.add(noticia3);
			lista.add(noticia4);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public List<Noticia> buscarTodasNoticias() {
		return lista;
	}

	@Override
	public Noticia buscarPorId(Integer idNoticia) {
		for(Noticia n : lista) {
			if (n.getId() == idNoticia) {
				return n;
			}
		}
		return null;
	}

	@Override
	public void guardarNoticia(Noticia noticia) {
		lista.add(noticia);
	}

	@Override
	public List<Noticia> buscarEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idNoticia) {
		
	}

}
