package sowad.aprumed.model;


import java.util.Date;

import sowad.aprumed.model.Categoria;

public class Libro {

	private int LibroID;
	private String Autor;
	private Date FechaPublicacion;
	private String Isbn;
	private Double Precio;
	private int Stock;
	private String Titulo;
	private Categoria Categoria;
	private String Estado;


	public Libro() {
	}

	public int getLibroID() {
		return LibroID;
	}

	public void setLibroID(int libroID) {
		LibroID = libroID;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public Date getFechaPublicacion() {
		return FechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		FechaPublicacion = fechaPublicacion;
	}

	public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String isbn) {
		Isbn = isbn;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public Categoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
}
