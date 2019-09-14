package sowad.aprumed.service;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import sowad.aprumed.dao.UsuarioDao;
import sowad.aprumed.mappers.TipoUsuarioMapper;
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
		String query = "insert into usuario (Apellido,Dni,Nombre,Sexo,Telefono,TipoUsuarioID)" + 
						" values (?,?,?,?,?,?)";
		Object[] inputs = new Object[] {
				usuario.getApellido(),
				usuario.getDni(),
				usuario.getNombre(),
				usuario.getSexo(),
				usuario.getTelefono(),
				usuario.getTipoUsuario().getTipoUsuarioID()
		};
		return jdbcTemplateObject.update(query, inputs);
	}

	@Override
	public int eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario buscarUsuario(String Dni) {
		String statement = "Select * from usuario where UsuarioID = "+Dni;
		return jdbcTemplateObject.queryForObject(statement, new UsuariosMapper());
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
