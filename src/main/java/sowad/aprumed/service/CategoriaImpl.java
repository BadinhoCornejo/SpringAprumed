package sowad.aprumed.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.CategoriaDao;
import sowad.aprumed.model.Categoria;

public class CategoriaImpl implements CategoriaDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int insertarCategoria(Categoria categoriaDao) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Categoria buscarCategoria(Categoria categoriaDao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editarCategoria(Categoria categoriaDao) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCategoria(Categoria categoriaDao) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Categoria> mostrarCategoria(Categoria categoriaDao) {
		// TODO Auto-generated method stub
		return null;
	}

}
