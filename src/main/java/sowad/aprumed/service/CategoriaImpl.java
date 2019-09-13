package sowad.aprumed.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.CategoriaDao;
import sowad.aprumed.model.Categoria;

public class CategoriaImpl implements CategoriaDao{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	public int insertarCategoria(Categoria categoria) {
		String query="insertarCategoria(?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] inputs = new Object[]
				{categoria.getNombreCategoria(),
				 categoria.getEstado()};
		return jdbcTemplate.update(query, inputs);
	}
	public Categoria buscarCategoria(String nombreCategoria) {
		String query="buscarCategoria(?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.update(query, nombreCategoria);
	}
	public int editarCategoria(Categoria categoria) {
		
	}
	public int eliminarCategoria(Categoria categoria) {
		
	}
	public List<Categoria> mostrarCategoria(Categoria categoria){
		
	}
}
