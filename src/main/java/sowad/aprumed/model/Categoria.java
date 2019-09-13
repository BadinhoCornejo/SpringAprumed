package sowad.aprumed.model;

public class Categoria {

	private int CategoriaID;
	private String NombreCategoria;
	private String Estado;
	@Override
	public String toString() {
		return "Categoria [CategoriaID=" + CategoriaID + ", NombreCategoria=" + NombreCategoria + ",Estado=" + Estado + "]";
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
	public String getEstado(){
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
}
