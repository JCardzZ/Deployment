package com.mm.com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String director;
	private String actores;
	private String sinopsis;
	private String trailer;
	private String idioma;
	private String ciudad;
	
	@OneToMany(mappedBy = "genero", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Pelicula> pelicula = new ArrayList<Pelicula>();


	public Detalle() {

	}

	public Detalle(String director, String actores, String sinopsis, String trailer, String idioma, String ciudad) {
		this.director = director;
		this.actores = actores;
		this.sinopsis = sinopsis;
		this.trailer = trailer;
		this.idioma = idioma;
		this.ciudad = ciudad;
	}

	public Detalle(Long id, String director, String actores, String sinopsis, String trailer, String idioma,
			String ciudad) {
		this.id = id;
		this.director = director;
		this.actores = actores;
		this.sinopsis = sinopsis;
		this.trailer = trailer;
		this.idioma = idioma;
		this.ciudad = ciudad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
