package sowad.aprumed.service;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import sowad.aprumed.dao.LibroDao;
import sowad.aprumed.mappers.EjemplarMapper;
import sowad.aprumed.mappers.LibrosMapper;
import sowad.aprumed.model.Ejemplar;
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
				libro.getPrecio(), libro.getStock(), libro.getTitulo(), libro.getCategoria().getCategoriaID(),
				libro.getEstado() };
		return jdbcTemplateObject.update(statement, inputs);
	}

	@Override
	public int eliminarLibro(int id) {
		String statement = "update libro " + "set Estado = \"Inactivo\" " + "where LibroID = '" + id + "'";

		return jdbcTemplateObject.update(statement);
	}

	@Override
	public int editarLibro(Libro libro) {
		String statement = "update libro " + "set Autor = '" + libro.getAutor() + "', " + "FechaPublicacion = '"
				+ libro.getFechaPublicacion() + "', " + "Isbn = '" + libro.getIsbn() + "', " + "Precio = '"
				+ libro.getPrecio() + "', " + "Titulo = '" + libro.getTitulo() + "', " + "CategoriaID = '"
				+ libro.getCategoria().getCategoriaID() + "', " + "Estado = '" + libro.getEstado() + "' "
				+ "where LibroID = '" + libro.getLibroID() + "'";
		return jdbcTemplateObject.update(statement);
	}

	@Override
	public Libro getLibroById(int id) {
		String statement = "select * from libro lbr inner join categoria cate on("
				+ "lbr.CategoriaID = cate.CategoriaID) " + "where lbr.LibroID = '" + id + "'";

		return jdbcTemplateObject.queryForObject(statement, new LibrosMapper());

	}

	@Override
	public int actualizarStock(Libro libro) {

		int stock = libro.getStock();

		String statement = "update libro set Stock = '" + stock + "' " + "where LibroID = '" + libro.getLibroID() + "'";

		return jdbcTemplateObject.update(statement);
	}

	//Para la búsqueda en general
	@Override
	public List<Ejemplar> buscarLibroEjemplar(String parameter) {

		String statement = "select l.Autor,l.FechaPublicacion, l.Estado, l.LibroID, l.Isbn, l.Titulo, l.Precio, l.Stock,"
				+ "c.CategoriaID, c.NombreCategoria, e.Sku,e. EjemplarID, e.Estado as \"EstadoEjemplar\" "
				+ "from libro l inner join ejemplar e on(l.LibroID = e.LibroID) "
				+ "inner join categoria c on(l.CategoriaID = c.CategoriaID) "
				+ "where e.estado = \"En almacen\" " + "AND (l.titulo LIKE '%" + parameter + "%' OR l.autor LIKE '%"
				+ parameter + "%')"+" group by l.isbn";

		return jdbcTemplateObject.query(statement, new EjemplarMapper());
	}

}
