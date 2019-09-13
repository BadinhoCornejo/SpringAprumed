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
import sowad.aprumed.model.Libro;
import sowad.aprumed.model.Categoria;

public class LibroImpl implements LibroDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int insertarLibro(Libro libro) {
		String query = "insert into libro(Autor,CategoriaID,Estado,FechaPulicacion,Isbn,LibroID,Precio,Stock,Titulo)"
				+ "values(?,?,?,?,?,?,?,?)";
		Object[] inputs = new Object[] { libro.getAutor(), libro.getCategoria().getCategoriaID(), libro.getEstado(),
				libro.getFechaPublicacion(), libro.getIsbn(), libro.getPrecio(), libro.getStock(), libro.getTitulo() };
		return jdbcTemplateObject.update(query, inputs);
	}

	private static class LibrosMapper implements RowMapper<Libro> {
		public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
			Libro lib = new Libro();
			lib.setLibroID(rs.getInt("LibroID"));
			lib.setAutor(rs.getString("Autor"));
			lib.setEstado(rs.getString("Estado"));
			lib.setFechaPublicacion(rs.getDate("FechaPublicacion"));
			lib.setIsbn(rs.getString("Isbn"));
			lib.setTitulo(rs.getString("Titulo"));
			lib.setPrecio(rs.getDouble("Precio"));
			lib.setStock(rs.getInt("Stock"));

			Categoria cat = new Categoria();
			cat.setCategoriaID(rs.getInt("CategoriaID"));
			cat.setNombreCategoria(rs.getString("NombreCategoria"));

			lib.setCategoria(cat);

			return lib;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Libro> mostrarLibros() {
		String proc = "SP_MostrarLibros";

		SimpleJdbcCall procedure = new SimpleJdbcCall(jdbcTemplateObject).withProcedureName(proc)
				.returningResultSet("RESULT", new LibrosMapper());

		Map<String, Object> out = procedure.execute();
		return (List<Libro>) out.get("RESULT");

	}

	/*
	 * public Libro buscarLibro(String titulo) { String query="buscarLibro(?)";
	 * jdbcTemplate = new JdbcTemplate(dataSource); return
	 * jdbcTemplate.update(query, titulo); }
	 */

	/*
	 * public int editarLibro(Libro libro) {
	 * 
	 * }
	 */

}
