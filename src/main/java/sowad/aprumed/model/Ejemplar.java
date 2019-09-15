package sowad.aprumed.model;

public class Ejemplar {
	public String Sku;
	public String Estado;
	public int EjemplarID;
	public Libro libro;
	public String getSku() {
		return Sku;
	}
	public void setSku(String sku) {
		Sku = sku;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getEjemplarID() {
		return EjemplarID;
	}
	public void setEjemplarID(int ejemplarID) {
		EjemplarID = ejemplarID;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
	
	
}
