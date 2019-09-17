package sowad.aprumed.dao;

import sowad.aprumed.model.ComprobantePago;

public interface ComprobantePagoDao {
	public int crearComprobante(ComprobantePago comprobantePago);
	public ComprobantePago reportarComprobante(int ventaID);
}
