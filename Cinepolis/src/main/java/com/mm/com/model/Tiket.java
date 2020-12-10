package com.mm.com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tikets")
public class Tiket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String descripcion;

	private String detalle;

	@Temporal(TemporalType.DATE)
	private Date fechaEmision;

	@ManyToOne(fetch = FetchType.LAZY) // Muchos Tikets pueden pertenecer a un solo cliente
	private Cliente cliente;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // Un tiket muchos items en el tiket
	@JoinColumn(name = "id_compraFK") // Relacion Unidireccional
	private List<Compra> items = new ArrayList<Compra>();

	@PrePersist
	public void prePersist() {
		fechaEmision = new Date();
	}

	public Tiket() {

	}

	public Tiket(String descripcion, String detalle, Date fechaEmision, Cliente cliente) {
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.fechaEmision = fechaEmision;
		this.cliente = cliente;
	}

	public Tiket(Long id, String descripcion, String detalle, Date fechaEmision, Cliente cliente) {
		this.id = id;
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.fechaEmision = fechaEmision;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Compra> getItems() {
		return items;
	}

	public void setItems(List<Compra> items) {
		this.items = items;
	}

	public void addItemTiket(Compra item) {
		this.items.add(item);
	}

	public Double getTotal() {
		Double total = 0.0;

		int size = items.size();

		for (int i = 0; i < size; i++) {
			total += items.get(i).calcularImporte();
		}
		return total;
	}



}
