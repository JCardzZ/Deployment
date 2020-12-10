package com.mm.com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo; // 2
	private String idioma; // 3
	private String duracion; // 4
	private String clasificacion; // 5
	private String subtitulos; // 6
	private String imagen = "default.png"; // 8
	private String imagenTrailer = "default.png"; // 8
	@Column(name = "fechaestreno")
	private Date fechaEstreno; // 9
	private String estatus = "Activa"; // 10
	private Integer destacada; // 11
	private String sinopsis;
	private String actores;
	private String directores;
	private String urlTrailer ="https://www.youtube.com/embed/";
	@Column(name = "precio_entrada")
	private Double precio; // 11

	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
	// @JoinColumn(name = "id_detalle", nullable = false)
	// private Detalle detalle;
//	@Transient
	@OneToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;

	public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	public Pelicula(String titulo, String idioma, String duracion, String clasificacion, String subtitulos,
			String imagen, String imagenTrailer, Date fechaEstreno, String estatus, Integer destacada, String sinopsis,
			String actores, String directores, String urlTrailer, Double precio, Genero genero) {
		super();
		this.titulo = titulo;
		this.idioma = idioma;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.subtitulos = subtitulos;
		this.imagen = imagen;
		this.imagenTrailer = imagenTrailer;
		this.fechaEstreno = fechaEstreno;
		this.estatus = estatus;
		this.destacada = destacada;
		this.sinopsis = sinopsis;
		this.actores = actores;
		this.directores = directores;
		this.urlTrailer = urlTrailer;
		this.precio = precio;
		this.genero = genero;
	}


	public Pelicula(Integer id, String titulo, String idioma, String duracion, String clasificacion, String subtitulos,
			String imagen, String imagenTrailer, Date fechaEstreno, String estatus, Integer destacada, String sinopsis,
			String actores, String directores, String urlTrailer, Double precio, Genero genero) {
		this.id = id;
		this.titulo = titulo;
		this.idioma = idioma;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.subtitulos = subtitulos;
		this.imagen = imagen;
		this.imagenTrailer = imagenTrailer;
		this.fechaEstreno = fechaEstreno;
		this.estatus = estatus;
		this.destacada = destacada;
		this.sinopsis = sinopsis;
		this.actores = actores;
		this.directores = directores;
		this.urlTrailer = urlTrailer;
		this.precio = precio;
		this.genero = genero;
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

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getSubtitulos() {
		return subtitulos;
	}

	public void setSubtitulos(String subtitulos) {
		this.subtitulos = subtitulos;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImagenTrailer() {
		return imagenTrailer;
	}

	public void setImagenTrailer(String imagenTrailer) {
		this.imagenTrailer = imagenTrailer;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getDestacada() {
		return destacada;
	}

	public void setDestacada(Integer destacada) {
		this.destacada = destacada;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getDirectores() {
		return directores;
	}

	public void setDirectores(String directores) {
		this.directores = directores;
	}

	public String getUrlTrailer() {
		return urlTrailer;
	}

	public void setUrlTrailer(String urlTrailer) {
		this.urlTrailer = urlTrailer;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void resetPelicula() {
		this.imagen = null;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", idioma=" + idioma + ", duracion=" + duracion
				+ ", clasificacion=" + clasificacion + ", subtitulos=" + subtitulos + ", imagen=" + imagen
				+ ", imagenTrailer=" + imagenTrailer + ", fechaEstreno=" + fechaEstreno + ", estatus=" + estatus
				+ ", destacada=" + destacada + ", sinopsis=" + sinopsis + ", actores=" + actores + ", directores="
				+ directores + ", urlTrailer=" + urlTrailer + ", precio=" + precio + ", genero=" + genero + "]";
	}




}
