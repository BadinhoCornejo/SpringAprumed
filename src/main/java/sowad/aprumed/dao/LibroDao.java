package sowad.aprumed.dao;

import java.util.List;

import sowad.aprumed.model.Libro;

public interface LibroDao {
	public List<Libro> mostrarLibros();
	public int crearLibro(Libro libro);
	public int eliminarLibro(Libro libro);
	public int editarLibro(Libro libro);
	
}
