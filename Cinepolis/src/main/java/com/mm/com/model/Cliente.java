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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	private String celular;
	@NotEmpty
	private String email;
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String departamento;
	@NotEmpty
	private String ciudad;

	@NotNull
	@Column(name = "fecha_tiket")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaTiket;

	private String foto;

//	@PrePersist
//	public void prePersist() {
//		fechaTiket = new Date();
//	}

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // Un cliente puede tener muchos
																						// tikets
	private List<Tiket> tikets = new ArrayList<Tiket>();

	public Cliente() {

	}

	public Cliente(@NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String celular, @NotEmpty String email,
			@NotEmpty String direccion, @NotEmpty String departamento, @NotEmpty String ciudad, Date fechaTiket,
			String foto, List<Tiket> tikets) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.fechaTiket = fechaTiket;
		this.foto = foto;
		this.tikets = tikets;
	}

	public Cliente(Long id, @NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String celular,
			@NotEmpty String email, @NotEmpty String direccion, @NotEmpty String departamento, @NotEmpty String ciudad,
			Date fechaTiket, String foto, List<Tiket> tikets) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.fechaTiket = fechaTiket;
		this.foto = foto;
		this.tikets = tikets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaTiket() {
		return fechaTiket;
	}

	public void setFechaTiket(Date fechaTiket) {
		this.fechaTiket = fechaTiket;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Tiket> getTikets() {
		return tikets;
	}

	public void setTikets(List<Tiket> tikets) {
		this.tikets = tikets;
	}
	

	public void addFactura(Tiket factura) {
		tikets.add(factura);
	}

	@Override
	public String toString() {
		return nombre + "  " + apellido; 

}
}
