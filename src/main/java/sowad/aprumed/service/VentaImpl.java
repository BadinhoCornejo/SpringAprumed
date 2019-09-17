package sowad.aprumed.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.VentaDao;
import sowad.aprumed.mappers.VentaMapper;
import sowad.aprumed.model.Venta;

public class VentaImpl implements VentaDao {
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int crearVenta(Venta venta) {
		String statement = "insert into venta (FechaVenta, HoraVenta, Estado, UsuarioID) " + "values(?,?,?,?)";

		Object[] inputs = new Object[] { venta.getFechaVenta(), venta.getHoraVenta(), venta.getEstado(),
				venta.getUsuario().getUsuarioID() };

		return jdbcTemplateObject.update(statement, inputs);
	}

	@Override
	public Venta buscarVentaUsuario(String dni) {
		String statement = "Select v.FechaVenta, v.HoraVenta, v.VentaID, v.Estado as \"EstadoVenta\", "
				+ "usr.UsuarioID, usr.Apellido, usr.Dni, usr.Nombre, usr.Sexo, usr.Telefono,\r\n"
				+ "tusr.NombreTipoUsuario " + "from venta v inner join usuario usr on(v.UsuarioID = usr.UsuarioID) "
				+ "inner join tipousuario tusr on(usr.TipoUsuarioID = tusr.TipoUsuarioID) "
				+ "where v.Estado = \"Activa\" AND usr.UsuarioID = '" + dni + "'";
		return jdbcTemplateObject.queryForObject(statement, new VentaMapper());
	}

	@Override
	public int setActiva(int id) {
		String statement = "Update venta " + "set Estado = \"Activa\" " + "Where VentaID = '" + id + "'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public int setInactiva(int id) {
		String statement = "Update venta " + "set Estado = \"Inactiva\" " + "Where VentaID = '" + id + "'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public int setRealizada(int id) {
		String statement = "Update venta " + "set Estado = \"Realizada\" " + "Where VentaID = '" + id + "'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public int setTiempoRealizacion(Venta venta) {
		String statement = "Update venta " + "set FechaVenta = '" + venta.getFechaVenta() + "', " + "HoraVenta = '"
				+ venta.getHoraVenta() + "' " + "Where VentaID = '" + venta.getVentaID() + "'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public List<Venta> mostrarVentas() {
		String statement = "Select v.FechaVenta, v.HoraVenta, v.VentaID, v.Estado as \"EstadoVenta\", "
				+ "usr.UsuarioID, usr.Apellido, usr.Dni, usr.Nombre, usr.Sexo, usr.Telefono, "
				+ "tusr.NombreTipoUsuario " + "from venta v inner join usuario usr on(v.UsuarioID = usr.UsuarioID) "
				+ "inner join tipousuario tusr on(usr.TipoUsuarioID = tusr.TipoUsuarioID) ";
		return jdbcTemplateObject.query(statement, new VentaMapper());
	}

}
