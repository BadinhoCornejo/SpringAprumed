package sowad.aprumed.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sowad.aprumed.model.TipoUsuario;

public class TipoUsuarioMapper implements RowMapper<TipoUsuario> {
	public TipoUsuario mapRow(ResultSet rs, int i) throws SQLException {
		TipoUsuario tipUsr = new TipoUsuario();
		tipUsr.setNombreTipoUsuario(rs.getString("NombreTipoUsuario"));
		tipUsr.setEstado(rs.getString("Estado"));
		tipUsr.setTipoUsuarioID(rs.getInt("TipoUsuarioID"));
		return tipUsr;
	}

}
