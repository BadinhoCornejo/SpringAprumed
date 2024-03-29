package sowad.aprumed.dao;

import java.util.List;

import sowad.aprumed.model.Ejemplar;
import sowad.aprumed.model.Libro;

public interface LibroDao {
	public List<Libro> mostrarLibros();
	public int crearLibro(Libro libro);
	public int eliminarLibro(int id);
	public int editarLibro(Libro libro);
	public Libro getLibroById(int id);
	public int actualizarStock(Libro libro);
	public List<Ejemplar> buscarLibroEjemplar(String parameter);
}
