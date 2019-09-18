package sowad.aprumed.model;

public class ComprobantePago {
	private String fechaCp;
	private String horaCp;
	private String ruc;
	private Double subtotal;
	private Venta venta;
	private int comprobantePagoID;
	
	public int getComprobantePagoID() {
		return comprobantePagoID;
	}
	public void setComprobantePagoID(int comprobantePagoID) {
		this.comprobantePagoID = comprobantePagoID;
	}
	public String getFechaCp() {
		return fechaCp;
	}
	public void setFechaCp(String fechaCp) {
		this.fechaCp = fechaCp;
	}
	public String getHoraCp() {
		return horaCp;
	}
	public void setHoraCp(String horaCp) {
		this.horaCp = horaCp;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
	
}
