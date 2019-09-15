package sowad.aprumed.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.mysql.cj.protocol.Resultset;

import sowad.aprumed.dao.LibroDao;
import sowad.aprumed.mappers.LibrosMapper;
import sowad.aprumed.model.Libro;

public class LibroImpl implements LibroDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("unchecked")
	public List<Libro> mostrarLibros() {
		String proc = "SP_MostrarLibros";

		SimpleJdbcCall procedure = new SimpleJdbcCall(jdbcTemplateObject).withProcedureName(proc)
				.returningResultSet("RESULT", new LibrosMapper());

		Map<String, Object> out = procedure.execute();
		return (List<Libro>) out.get("RESULT");

	}

	@Override
	public int crearLibro(Libro libro) {
		String statement = "insert into libro(" + "Autor," + " FechaPublicacion," + " Isbn," + " Precio," + " Stock,"
				+ " Titulo," + " CategoriaID," + " Estado) " + "values(?,?,?,?,?,?,?,?,?)";

		Object[] inputs = new Object[] { libro.getAutor(), libro.getFechaPublicacion(), libro.getIsbn(),
				libro.getPrecio(), 0, libro.getTitulo(), libro.getCategoria().getCategoriaID(), libro.getEstado() };
		return jdbcTemplateObject.update(statement, inputs);
	}

	@Override
	public int eliminarLibro(Libro libro) {
		String statement = "update libro " + "set Estado = \"Inactivo\" " + "where LibroID = '" + libro.getLibroID()
				+ "'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public int editarLibro(Libro libro) {
		String statement = "update libro " + "set Autor = '" + libro.getAutor() + "', " + "FechaPublicacion = '"
				+ libro.getFechaPublicacion() + "', " + "Isbn = '" + libro.getIsbn() + "', " + "Precio = '"
				+ libro.getPrecio() + "', " + "Titulo = '" + libro.getTitulo() + "', " + "CategoriaID = '"
				+ libro.getCategoria() + "', " + "Estado = '" + libro.getEstado() + "' " + "where LibroID = '"
				+ libro.getLibroID() + "'";
		return jdbcTemplateObject.update(statement);
	}

}
