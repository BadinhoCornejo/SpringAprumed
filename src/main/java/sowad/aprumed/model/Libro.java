package sowad.aprumed.model;

import java.io.Serializable;
import java.util.Date;

public class Libro implements Serializable {

	@Override
	public String toString() {
		return "Libro [LibroID=" + LibroID + ", Autor=" + Autor + ", FechaPublicacion=" + FechaPublicacion + ", Isbn="
				+ Isbn + ", Precio=" + Precio + ", Stock=" + Stock + ", Titulo=" + Titulo + ", CategoriaID="
				+ CategoriaID + "]";
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
	public int getCategoriaID() {
		return CategoriaID;
	}
	public void setCategoriaID(int categoriaID) {
		CategoriaID = categoriaID;
	}
	private int LibroID;
	private String Autor;
	private Date FechaPublicacion;
	private String Isbn;
	private Double Precio;
	private int Stock;
	private String Titulo;
	private int CategoriaID;
}
