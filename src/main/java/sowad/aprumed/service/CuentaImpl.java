package sowad.aprumed.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.CuentaDao;
import sowad.aprumed.model.Cuenta;

public class CuentaImpl implements CuentaDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int crearCuenta(Cuenta cuenta) {
		
		String query = "insert into cuenta (Email,Estado,UsrPassword,UsuarioID)"
				+ " values (?,?,?,?)";
		Object[] inputs = new Object[] { 
				cuenta.getEmail(),
				cuenta.getEstado(),
				cuenta.getUsrPassword(),
				cuenta.getUsuario().getUsuarioID()
		};
		return jdbcTemplateObject.update(query, inputs);
	}

	@Override
	public int eliminarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarCuenta(Cuenta cuenta) {
		String statement = "Update cuenta" + " set Email = '"+ cuenta.getEmail() + "' "
							+ "UsrPassword = '"+ cuenta.getUsrPassword() + "' "
							+ "Estado = '"+ cuenta.getEstado() + 
							" where CuentaID = '"+ cuenta.getCuentaID()+"'";
		
		return jdbcTemplateObject.update(statement);
	}

}
