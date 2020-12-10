package com.mm.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cartelera")
public class Cartelera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String archivo;
	private String estado;

	public Cartelera() {
		// TODO Auto-generated constructor stub
	}

	public Cartelera(String titulo, String archivo, String estado) {
		this.titulo = titulo;
		this.archivo = archivo;
		this.estado = estado;
	}

	public Cartelera(Integer id, String titulo, String archivo, String estado) {
		this.id = id;
		this.titulo = titulo;
		this.archivo = archivo;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cartelera [id=" + id + ", titulo=" + titulo + ", archivo=" + archivo + ", estado=" + estado + "]";
	}

	
}
