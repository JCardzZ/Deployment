package com.mm.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noticias")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tituloGrande;
	private String descripcionPeque;
	private String tituloGrandeTendencia;
	private String descripcionpeqtend;
	private String tituloGrandeNumeros;
	private String descripcionNumeros;
	private String tituloGrandeApp;
	private String descripcionPequeaApp;
	private Date fecha;
	private String detalle;
	private String estado = "Activa"; // 10
//	private Integer estado;
	private String imagenNoticia = "no-image.png";
	private String urlImgNoticia;

	public Noticia() {

	}

	public Noticia(String tituloGrande, String descripcionPeque, String tituloGrandeTendencia,
			String descripcionpeqtend, String tituloGrandeNumeros, String descripcionNumeros, String tituloGrandeApp,
			String descripcionPequeaApp, Date fecha, String detalle, String estado, String imagenNoticia,
			String urlImgNoticia) {
		this.tituloGrande = tituloGrande;
		this.descripcionPeque = descripcionPeque;
		this.tituloGrandeTendencia = tituloGrandeTendencia;
		this.descripcionpeqtend = descripcionpeqtend;
		this.tituloGrandeNumeros = tituloGrandeNumeros;
		this.descripcionNumeros = descripcionNumeros;
		this.tituloGrandeApp = tituloGrandeApp;
		this.descripcionPequeaApp = descripcionPequeaApp;
		this.fecha = fecha;
		this.detalle = detalle;
		this.estado = estado;
		this.imagenNoticia = imagenNoticia;
		this.urlImgNoticia = urlImgNoticia;
	}

	public Noticia(Integer id, String tituloGrande, String descripcionPeque, String tituloGrandeTendencia,
			String descripcionpeqtend, String tituloGrandeNumeros, String descripcionNumeros, String tituloGrandeApp,
			String descripcionPequeaApp, Date fecha, String detalle, String estado, String imagenNoticia,
			String urlImgNoticia) {
		this.id = id;
		this.tituloGrande = tituloGrande;
		this.descripcionPeque = descripcionPeque;
		this.tituloGrandeTendencia = tituloGrandeTendencia;
		this.descripcionpeqtend = descripcionpeqtend;
		this.tituloGrandeNumeros = tituloGrandeNumeros;
		this.descripcionNumeros = descripcionNumeros;
		this.tituloGrandeApp = tituloGrandeApp;
		this.descripcionPequeaApp = descripcionPequeaApp;
		this.fecha = fecha;
		this.detalle = detalle;
		this.estado = estado;
		this.imagenNoticia = imagenNoticia;
		this.urlImgNoticia = urlImgNoticia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTituloGrande() {
		return tituloGrande;
	}

	public void setTituloGrande(String tituloGrande) {
		this.tituloGrande = tituloGrande;
	}

	public String getDescripcionPeque() {
		return descripcionPeque;
	}

	public void setDescripcionPeque(String descripcionPeque) {
		this.descripcionPeque = descripcionPeque;
	}

	public String getTituloGrandeTendencia() {
		return tituloGrandeTendencia;
	}

	public void setTituloGrandeTendencia(String tituloGrandeTendencia) {
		this.tituloGrandeTendencia = tituloGrandeTendencia;
	}

	public String getDescripcionpeqtend() {
		return descripcionpeqtend;
	}

	public void setDescripcionpeqtend(String descripcionpeqtend) {
		this.descripcionpeqtend = descripcionpeqtend;
	}

	public String getTituloGrandeNumeros() {
		return tituloGrandeNumeros;
	}

	public void setTituloGrandeNumeros(String tituloGrandeNumeros) {
		this.tituloGrandeNumeros = tituloGrandeNumeros;
	}

	public String getDescripcionNumeros() {
		return descripcionNumeros;
	}

	public void setDescripcionNumeros(String descripcionNumeros) {
		this.descripcionNumeros = descripcionNumeros;
	}

	public String getTituloGrandeApp() {
		return tituloGrandeApp;
	}

	public void setTituloGrandeApp(String tituloGrandeApp) {
		this.tituloGrandeApp = tituloGrandeApp;
	}

	public String getDescripcionPequeaApp() {
		return descripcionPequeaApp;
	}

	public void setDescripcionPequeaApp(String descripcionPequeaApp) {
		this.descripcionPequeaApp = descripcionPequeaApp;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagenNoticia() {
		return imagenNoticia;
	}

	public void setImagenNoticia(String imagenNoticia) {
		this.imagenNoticia = imagenNoticia;
	}

	public String getUrlImgNoticia() {
		return urlImgNoticia;
	}

	public void setUrlImgNoticia(String urlImgNoticia) {
		this.urlImgNoticia = urlImgNoticia;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", tituloGrande=" + tituloGrande + ", descripcionPeque=" + descripcionPeque
				+ ", tituloGrandeTendencia=" + tituloGrandeTendencia + ", descripcionpeqtend=" + descripcionpeqtend
				+ ", tituloGrandeNumeros=" + tituloGrandeNumeros + ", descripcionNumeros=" + descripcionNumeros
				+ ", tituloGrandeApp=" + tituloGrandeApp + ", descripcionPequeaApp=" + descripcionPequeaApp + ", fecha="
				+ fecha + ", detalle=" + detalle + ", estado=" + estado + ", imagenNoticia=" + imagenNoticia
				+ ", urlImgNoticia=" + urlImgNoticia + "]";
	}

}
