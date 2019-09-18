package sowad.aprumed.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.ComprobantePagoDao;
import sowad.aprumed.mappers.ComprobantePagoMapper;
import sowad.aprumed.model.ComprobantePago;

public class ComprobantePagoImpl implements ComprobantePagoDao {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int crearComprobante(ComprobantePago comprobantePago) {
		String statement = "insert into comprobantepago (FechaCp, HoraCp, Ruc, Subtotal, VentaID) "
				+ "values (?,?,?,?,?)";
		Object[] inputs = new Object[] { comprobantePago.getFechaCp(), comprobantePago.getHoraCp(),
				comprobantePago.getRuc(), comprobantePago.getSubtotal(), comprobantePago.getVenta().getVentaID() };

		return jdbcTemplateObject.update(statement, inputs);
	}

	@Override
	public ComprobantePago reportarComprobante(int ventaID) {
		String statement = "select * from comprobantepago cp "
				+ "inner join venta v on(cp.VentaID = v.VentaID) "
				+ "where v.VentaID = '"+ventaID+"'";
		
		return jdbcTemplateObject.queryForObject(statement, new ComprobantePagoMapper());
	}

}
