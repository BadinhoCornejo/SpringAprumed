package sowad.aprumed.service;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import sowad.aprumed.dao.EjemplarDao;
import sowad.aprumed.mappers.EjemplarMapper;
import sowad.aprumed.mappers.UsuariosMapper;
import sowad.aprumed.model.Ejemplar;

public class EjemplarImpl implements EjemplarDao {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int crearEjemplar(Ejemplar ejemplar) {
		String statement = "insert into ejemplar (Sku, Estado, LibroID) " + "values(?,?,?)";

		Object[] inputs = new Object[] { ejemplar.getSku(), ejemplar.getEstado(), ejemplar.getLibro().getLibroID() };
		return jdbcTemplateObject.update(statement, inputs);
	}

	@Override
	public int enCarrito(int id) {
		String statement = "Update ejemplar " + "set Estado = \"En carrito\" " + "Where EjemplarID = '"+id+"'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public int enAlmacen(int id) {
		String statement = "Update ejemplar " + "set Estado = \"En almacen\" " + "Where EjemplarID = '"+id+"'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public int vendido(int id) {
		String statement = "Update ejemplar " + "set Estado = \"Vendido\" " + "Where EjemplarID = '"+id+"'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public List<Ejemplar> mostrarEjemplares(String libroID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ejemplar buscarEjemplar(String sku) {
		String proc = "SP_BuscarEjemplar";

		SimpleJdbcCall procedure = new SimpleJdbcCall(jdbcTemplateObject).withProcedureName(proc)
				.returningResultSet("RESULT", new EjemplarMapper());

		Map<String, Object> out = procedure.execute();
		return (Ejemplar) out.get("RESULT");
	}

}
