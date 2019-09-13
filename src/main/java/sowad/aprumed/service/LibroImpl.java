package sowad.aprumed.service;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import sowad.aprumed.dao.LibroDao;
import sowad.aprumed.model.Libro;

public class LibroImpl implements LibroDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public int insertarLibro(Libro libro) {
		String query = "insert into libro(Autor,CategoriaID,Estado,FechaPulicacion,Isbn,LibroID,Precio,Stock,Titulo)"
				+"values(?,?,?,?,?,?,?,?)";
		Object[] inputs = new Object[]
				{
						libro.getAutor(),
						libro.getCategoriaID(),
						libro.getEstado(),
						libro.getFechaPublicacion(),
						libro.getIsbn(),
						libro.getPrecio(),
						libro.getStock(),
						libro.getTitulo()
				};
		return jdbcTemplateObject.update(query,inputs);
	}
	
	public List<Libro> libros(){
		String proc = "SP_MostrarLibros";
		
		SimpleJdbcCall procedure = new SimpleJdbcCall(jdbcTemplateObject)
				.withProcedureName(proc)
				.returningResultSet("RESULT", rowMapper);
		Map<String, Object> out = procedure.execute();
		   return (List<Libro>) out.get("RESULT");
		
		
	}
	
	/*
	public Libro buscarLibro(String titulo) {
		String query="buscarLibro(?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.update(query, titulo);
	}
	*/
	
	/*
	public int editarLibro(Libro libro) {
		
	}
	*/
	
}
