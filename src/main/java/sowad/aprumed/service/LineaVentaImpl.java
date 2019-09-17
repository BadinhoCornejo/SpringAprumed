package sowad.aprumed.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.LineaVentaDao;
import sowad.aprumed.model.Ejemplar;
import sowad.aprumed.model.Venta;

public class LineaVentaImpl implements LineaVentaDao {
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int agregarLineaVenta(Ejemplar ejemplar, Venta venta) {
		String statement = "insert into lineaventa (EjemplarID, VentaID) " + "values (?,?)";
		Object[] inputs = new Object[] { ejemplar.getEjemplarID(), venta.getVentaID() };

		return jdbcTemplateObject.update(statement, inputs);
	}

}
