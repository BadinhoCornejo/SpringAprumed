package sowad.aprumed.service;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import sowad.aprumed.dao.UsuarioDao;
import sowad.aprumed.mappers.UsuarioMapper;
import sowad.aprumed.mappers.UsuariosMapper;
import sowad.aprumed.model.Usuario;

public class UsuarioImpl implements UsuarioDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int crearUsuario(Usuario usuario) {
		String query = "insert into usuario (Apellido,Dni,Nombre,Sexo,Telefono,TipoUsuarioID)"
				+ " values (?,?,?,?,?,?)";
		Object[] inputs = new Object[] { usuario.getApellido(), usuario.getDni(), usuario.getNombre(),
				usuario.getSexo(), usuario.getTelefono(), usuario.getTipoUsuario().getTipoUsuarioID() };
		return jdbcTemplateObject.update(query, inputs);
	}

	@Override
	public int eliminarUsuario(Usuario usuario) {

		String statement = "Update cuenta" + " set Estado = \"Inactivo\"" + " where UsuarioID = ?";

		Object[] inputs = new Object[] { usuario.getUsuarioID() };

		return jdbcTemplateObject.update(statement, inputs);
	}

	@Override
	public int editarUsuario(Usuario usuario) {

		String statement = "Update usuario" + " set Apellido = '" + usuario.getApellido() + "' " + "Dni = '"
				+ usuario.getDni() + "' " + "Sexo = '" + usuario.getSexo() + "' Nombre = '" + usuario.getNombre()
				+ "' Telefono = '" + usuario.getTelefono() + "' TipoUsuarioID = '"
				+ usuario.getTipoUsuario().getTipoUsuarioID() + "' "+
				" where UsuarioID ='"+usuario.getUsuarioID()+"'";

		return jdbcTemplateObject.update(statement);

	}

	@Override
	public Usuario buscarUsuario(String Dni) {
		String statement = "Select * from usuario usr inner join tipousuario tipUsr on(usr.TipoUsuarioID = tipUsr.TipoUsuarioID)"
				+ " where usr.Dni = ?";
		Object[] inputs = new Object[] { Dni };
		return jdbcTemplateObject.queryForObject(statement, inputs, new UsuarioMapper());
	}

	@Override
	public Usuario buscarUsuarioCuenta(String id) {
		String statement = "Select * from usuario usr inner join tipousuario tipUsr on(usr.TipoUsuarioID = tipUsr.TipoUsuarioID)"
				+ "inner join aprumeddb.cuenta acc on(usr.UsuarioID = acc.UsuarioID)" + " where usr.UsuarioID = ?";
		Object[] inputs = new Object[] { id };
		return jdbcTemplateObject.queryForObject(statement, inputs, new UsuarioMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> mostrarUsuarios() {
		String proc = "SP_MostrarUsuarios";

		SimpleJdbcCall procedure = new SimpleJdbcCall(jdbcTemplateObject).withProcedureName(proc)
				.returningResultSet("RESULT", new UsuariosMapper());

		Map<String, Object> out = procedure.execute();
		return (List<Usuario>) out.get("RESULT");
	}

}
