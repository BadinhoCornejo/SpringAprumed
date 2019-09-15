package sowad.aprumed.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.EjemplarDao;
import sowad.aprumed.model.Ejemplar;

public class EjemplarImpl implements EjemplarDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int crearEjemplar(Ejemplar ejemplar) {
		String statement = "insert into ejemplar (Sku, Estado, LibroID) "
				+ "values(?,?,?)";
		
		Object[] inputs = new Object[] { ejemplar.getSku(), ejemplar.getEstado(), ejemplar.getLibro().getLibroID()};
		return jdbcTemplateObject.update(statement, inputs);
	}

	@Override
	public int enCarrito(String sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int enAlmacen(String sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int vendido(String sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ejemplar> mostrarEjemplares(String libroID) {
		
		return null;
	}
	
}
