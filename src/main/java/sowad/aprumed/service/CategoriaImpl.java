package sowad.aprumed.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.CategoriaDao;
import sowad.aprumed.mappers.CategoriaMapper;
import sowad.aprumed.model.Categoria;

public class CategoriaImpl implements CategoriaDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int insertarCategoria(Categoria categoria) {
		String query="insert into categoria (Nombrecategoria,Estado)"
					+" values (?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] inputs = new Object[]
				{categoria.getNombreCategoria(),
				 categoria.getEstado()};
		return jdbcTemplate.update(query, inputs);
	}
	@Override
	public Categoria buscarCategoria(int id) {
		String query="select * from categoria where CategoriaID=?";
		Object[] inputs=new Object[] {id};
		return jdbcTemplate.queryForObject(query, inputs, new CategoriaMapper());
	}

	@Override
	 public int editarCategoria(Categoria categoria) {
		 
		 String query = "Update categoria"+ " set NombreCategoria=?"
				 		+ " values (?)";
		 Object[] inputs = new Object[] {categoria.getNombreCategoria()};
	  return jdbcTemplate.update(query, inputs);
	 }
	 @Override
	public int eliminarCategoria(Categoria categoria) {
	 
		String query = "Update categoria" + " set Estado =\"Inactivo\""
					+" where CategoriaID=?";
		Object[] inputs = new Object[] {categoria.getCategoriaID()};
		return jdbcTemplate.update(query, inputs);
	 }
	 
	@Override
	public List<Categoria> mostrarCategorias(){
		String query="Select * from categoria";
		return jdbcTemplate.query(query,new CategoriaMapper());
	}

}
