package sowad.aprumed.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.CategoriaDao;
import sowad.aprumed.mappers.CategoriaMapper;
import sowad.aprumed.model.Categoria;

public class CategoriaImpl implements CategoriaDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insertarCategoria(Categoria categoria) {
		String query = "insert into categoria (NombreCategoria,Estado)" + " values (?,?)";
		Object[] inputs = new Object[] { categoria.getNombreCategoria(), categoria.getEstado() };
		return jdbcTemplate.update(query, inputs);
	}

	@Override
	public Categoria buscarCategoria(String nombreCategoria) {
		String query = "select * from categoria where NombreCategoria= '" + nombreCategoria + "'";
		return jdbcTemplate.queryForObject(query, new CategoriaMapper());
	}

	@Override
	public int editarCategoria(Categoria categoria) {

		String query = "Update categoria" + " set NombreCategoria= '" + categoria.getNombreCategoria() + "', "
				+ "Estado = '" + categoria.getEstado() + "'" + " where CategoriaID = '" + categoria.getCategoriaID()
				+ "'";
		return jdbcTemplate.update(query);
	}

	@Override
	public int eliminarCategoria(Categoria categoria) {

		String query = "Update categoria" + " set Estado =\"Inactivo\"" + " where CategoriaID = '"
				+ categoria.getCategoriaID() + "'";
		return jdbcTemplate.update(query);
	}

	@Override
	public List<Categoria> mostrarCategorias() {
		String query = "Select * from categoria";
		return jdbcTemplate.query(query, new CategoriaMapper());
	}

}
