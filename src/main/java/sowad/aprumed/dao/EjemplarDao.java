package sowad.aprumed.dao;

import java.util.List;

import sowad.aprumed.model.Ejemplar;

public interface EjemplarDao {
	public int crearEjemplar(Ejemplar ejemplar);
	public Ejemplar buscarEjemplar(String sku);
	public int enCarrito(int id);
	public int enAlmacen(int id);
	public int vendido(int id);
	public List<Ejemplar> mostrarEjemplares(String libroID);
}
