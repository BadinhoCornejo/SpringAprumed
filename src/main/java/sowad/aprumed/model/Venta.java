package sowad.aprumed.model;

import java.util.Date;

public class Venta {
	private int ventaID;
	private String estado;
	private Date fechaVenta;
	private Date horaVenta;
	public int getVentaID() {
		return ventaID;
	}
	public void setVentaID(int ventaID) {
		this.ventaID = ventaID;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Date getHoraVenta() {
		return horaVenta;
	}
	public void setHoraVenta(Date horaVenta) {
		this.horaVenta = horaVenta;
	}


}
