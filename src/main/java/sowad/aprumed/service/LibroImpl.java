package sowad.aprumed.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import sowad.aprumed.dao.LibroDao;
import sowad.aprumed.model.Libro;

public class LibroImpl implements LibroDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int insertarLibro(Libro libro) {
		String query = "insert into libro(Autor,CategoriaID,Estado,FechaPulicacion,Isbn,LibroID,Precio,Stock,Titulo)"
				+"values(?,?,?,?,?,?,?,?)";
		jdbcTemplate =new JdbcTemplate(dataSource);
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
		return jdbcTemplate.update(query,inputs);
	}
	
	public Libro buscarLibro(String tituo) {
		String query="buscarLibro(?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.update(query, titulo);
	}
	public int editarLibro(Libro libro) {
		
	}
	
	
}
