package sowad.aprumed.model;

public class Categoria {

	private int CategoriaID;
	private String NombreCategoria;
	
	@Override
	public String toString() {
		return "Categoria [CategoriaID=" + CategoriaID + ", NombreCategoria=" + NombreCategoria + "]";
	}
	
	public int getCategoriaID() {
		return CategoriaID;
	}
	public void setCategoriaID(int categoriaID) {
		CategoriaID = categoriaID;
	}
	public String getNombreCategoria() {
		return NombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		NombreCategoria = nombreCategoria;
	}
	
}
