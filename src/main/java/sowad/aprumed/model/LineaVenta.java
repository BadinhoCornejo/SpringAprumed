package sowad.aprumed.model;

public class LineaVenta {
	private int lineaVentaID;
	private Ejemplar ejemplar;
	private Venta venta;
	public int getLineaVentaID() {
		return lineaVentaID;
	}
	public void setLineaVentaID(int lineaVentaID) {
		this.lineaVentaID = lineaVentaID;
	}
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
	
}
