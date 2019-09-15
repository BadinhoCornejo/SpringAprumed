package sowad.aprumed.dao;

import java.util.List;

import sowad.aprumed.model.Categoria;

public interface CategoriaDao {
	public int insertarCategoria(Categoria categoriaDao);
	public Categoria buscarCategoria(String nombreCategoria);
	public int editarCategoria(Categoria categoriaDao);
	public int eliminarCategoria(Categoria categoria);
	public List<Categoria> mostrarCategorias();
}
