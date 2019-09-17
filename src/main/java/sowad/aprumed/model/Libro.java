package sowad.aprumed.model;

import sowad.aprumed.model.Categoria;

public class Libro {

	private int libroID;
	private String autor;
	private String fechaPublicacion;
	private String isbn;
	private Double precio;
	private int stock;
	private String titulo;
	private Categoria categoria;
	private String estado;

	public int getLibroID() {
		return libroID;
	}

	public void setLibroID(int libroID) {
		this.libroID = libroID;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void addStock() {
		this.stock = this.stock + 1;
	}
	
	public void quitStock() {
		this.stock = this.stock - 1;
	}

}
