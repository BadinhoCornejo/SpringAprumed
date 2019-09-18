package sowad.aprumed.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sowad.aprumed.model.Cuenta;
import sowad.aprumed.model.Usuario;

public class UsuariosMapper implements RowMapper<Usuario> {
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usr = new UsuarioMapper().mapRow(rs, rowNum);

		Cuenta cuenta = new Cuenta();
		cuenta.setEmail(rs.getString("Email"));
		cuenta.setEstado(rs.getString("Estado"));

		usr.setCuenta(cuenta);

		return usr;
	}
}
