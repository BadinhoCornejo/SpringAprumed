package sowad.aprumed.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.TipoUsuarioDao;
import sowad.aprumed.mappers.TipoUsuarioMapper;
import sowad.aprumed.model.TipoUsuario;

public class TipoUsuarioImpl implements TipoUsuarioDao {
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
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
		String statement = "Select * from tipousuario where NombreTipoUsuario = ?";
		Object[] inputs = new Object[] { nombreTipoUsuario };
		return jdbcTemplateObject.queryForObject(statement, inputs, new TipoUsuarioMapper());
	}

	@Override
	public List<TipoUsuario> mostrarTiposUsuario() {
		String statement = "Select * from tipousuario";
		return jdbcTemplateObject.query(statement, new TipoUsuarioMapper());
	}

}
