package sowad.aprumed.dao;

import sowad.aprumed.model.Ejemplar;
import sowad.aprumed.model.Venta;

public interface LineaVentaDao {
	public int agregarLineaVenta(Ejemplar ejemplar, Venta venta);
}
