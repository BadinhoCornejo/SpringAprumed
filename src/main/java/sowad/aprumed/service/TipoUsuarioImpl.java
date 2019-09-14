package sowad.aprumed.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.cj.protocol.Resultset;

import sowad.aprumed.dao.TipoUsuarioDao;
import sowad.aprumed.model.TipoUsuario;

public class TipoUsuarioImpl implements TipoUsuarioDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int eliminarTipoUsuario(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarTipoUsuario(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TipoUsuario buscarTipoUsuario(String nombreTipoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoUsuario> mostrarTiposUsuario() {
		String statement = "Select * from tipousuario";
		return jdbcTemplateObject.query(statement, new RowMapper<TipoUsuario>() {
			@Override
			public TipoUsuario mapRow(ResultSet rs, int i) throws SQLException{
				TipoUsuario tipUsr = new TipoUsuario();
				tipUsr.setNombreTipoUsuario(rs.getString("NombreTipoUsuario"));
				tipUsr.setEstado(rs.getString("Estado"));
				tipUsr.setTipoUsuarioID(rs.getInt("TipoUsuarioID"));
				return tipUsr;
			}
		});
	}

}
