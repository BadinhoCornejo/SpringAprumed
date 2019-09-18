package sowad.aprumed.dao;


import java.util.List;

import sowad.aprumed.model.Venta;

public interface VentaDao {
	public int crearVenta(Venta venta);
	public Venta buscarVentaUsuario(String dni);
	public int setActiva(int id);
	public int setInactiva(int id);
	public int setRealizada(int id);
	public int setTiempoRealizacion(Venta venta);
	public List<Venta> mostrarVentas();
}
