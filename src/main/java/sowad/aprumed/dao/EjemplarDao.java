package sowad.aprumed.dao;

import java.util.List;

import sowad.aprumed.model.Ejemplar;

public interface EjemplarDao {
	public int crearEjemplar(Ejemplar ejemplar);
	public int enCarrito(String sku);
	public int enAlmacen(String sku);
	public int vendido(String sku);
	public List<Ejemplar> mostrarEjemplares(String libroID);
}
