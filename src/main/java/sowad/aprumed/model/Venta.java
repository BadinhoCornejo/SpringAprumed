package sowad.aprumed.model;

import java.util.Date;

public class Venta {
	private int VentaID;
	private String Estado;
	private Date FechaVenta;
	private Date HoraVenta;

	public Venta(int ventaID, String estado, Date fechaVenta, Date horaVenta) {
		super();
		VentaID = ventaID;
		Estado = estado;
		FechaVenta = fechaVenta;
		HoraVenta = horaVenta;
	}

	public Venta() {
	}

	public int getVentaID() {
		return VentaID;
	}

	public void setVentaID(int ventaID) {
		VentaID = ventaID;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Date getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		FechaVenta = fechaVenta;
	}

	public Date getHoraVenta() {
		return HoraVenta;
	}

	public void setHoraVenta(Date horaVenta) {
		HoraVenta = horaVenta;
	}
	
	
}
