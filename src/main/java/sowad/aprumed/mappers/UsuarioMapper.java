package sowad.aprumed.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sowad.aprumed.model.TipoUsuario;
import sowad.aprumed.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usr = new Usuario();
		usr.setUsuarioID(rs.getInt("UsuarioID"));
		usr.setDni(rs.getString("Dni"));
		usr.setApellido(rs.getString("Apellido"));
		usr.setNombre(rs.getString("Nombre"));
		usr.setSexo(rs.getString("Sexo"));
		usr.setTelefono(rs.getString("Telefono"));

		TipoUsuario tipUsr = new TipoUsuario();
		tipUsr.setNombreTipoUsuario(rs.getString("NombreTipoUsuario"));

		usr.setTipoUsuario(tipUsr);

		return usr;
	}
}
