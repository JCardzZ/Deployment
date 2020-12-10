package com.mm.com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "horarios")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_pelicula")
	private Date dia;

	@Column(name = "hora_pelicula")
	private String hora;

	private String sala;

	private Double precio;

	@OneToMany(mappedBy = "horario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Funcion> funciones = new ArrayList<Funcion>();

	public Horario() {

	}

	public Horario(Date dia, String hora, String sala, Double precio) {
		this.dia = dia;
		this.hora = hora;
		this.sala = sala;
		this.precio = precio;
	}

	public Horario(Long id, Date dia, String hora, String sala, Double precio) {
		this.id = id;
		this.dia = dia;
		this.hora = hora;
		this.sala = sala;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
