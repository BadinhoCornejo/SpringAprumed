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

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
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
				+ " Titulo," + " CategoriaID," + " Estado) " + "values(?,?,?,?,?,?,?,?)";

		Object[] inputs = new Object[] { libro.getAutor(), libro.getFechaPublicacion(), libro.getIsbn(),
				libro.getPrecio(), libro.getStock(), libro.getTitulo(), libro.getCategoria().getCategoriaID(), libro.getEstado() };
		return jdbcTemplateObject.update(statement, inputs);
	}

	@Override
	public int eliminarLibro(int id) {
		String statement = "update libro " + "set Estado = \"Inactivo\" " + "where LibroID = '" + id
				+ "'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public int editarLibro(Libro libro) {
		String statement = "update libro " + "set Autor = '" + libro.getAutor() + "', " + "FechaPublicacion = '"
				+ libro.getFechaPublicacion() + "', " + "Isbn = '" + libro.getIsbn() + "', " + "Precio = '"
				+ libro.getPrecio() + "', " + "Titulo = '" + libro.getTitulo() + "', " + "CategoriaID = '"
				+ libro.getCategoria().getCategoriaID() + "', " + "Estado = '" + libro.getEstado() + "' " + "where LibroID = '"
				+ libro.getLibroID() + "'";
		return jdbcTemplateObject.update(statement);
	}

	@Override
	public Libro getLibroById(int id) {
		String statement = "select * from libro lbr inner join categoria cate on("
				+ "lbr.CategoriaID = cate.CategoriaID) "
				+ "where lbr.LibroID = '"+id+"'";
		
		return jdbcTemplateObject.queryForObject(statement, new LibrosMapper());

	}

	@Override
	public int actualizarStock(Libro libro) {
		
		int stock = libro.getStock()+1;
		
		String statement = "update libro set Stock = '"+stock+"' "
				+ "where LibroID = '"+libro.getLibroID()+"'";
		
		return jdbcTemplateObject.update(statement);
	}

}
