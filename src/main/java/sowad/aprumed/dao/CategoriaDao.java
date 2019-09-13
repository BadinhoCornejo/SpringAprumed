package sowad.aprumed.dao;

import java.util.List;

import sowad.aprumed.model.Categoria;

public interface CategoriaDao {
	public int insertarCategoria(Categoria categoriaDao);
	public Categoria buscarCategoria(Categoria categoriaDao);
	public int editarCategoria(Categoria categoriaDao);
	public int eliminarCategoria(Categoria categoriaDao);
	public List<Categoria> mostrarCategoria(Categoria categoriaDao);
}
