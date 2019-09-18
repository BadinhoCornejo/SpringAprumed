package sowad.aprumed.model;

public class Ejemplar {
	public String sku;
	public String estado;
	public int ejemplarID;
	public Libro libro;
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getEjemplarID() {
		return ejemplarID;
	}
	public void setEjemplarID(int ejemplarID) {
		this.ejemplarID = ejemplarID;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	
	
	
	
	
}
