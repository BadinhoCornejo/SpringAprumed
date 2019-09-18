package sowad.aprumed.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import sowad.aprumed.model.Categoria;
import sowad.aprumed.model.Libro;

public class LibrosMapper implements RowMapper<Libro> {

	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Libro lib = new Libro();
		lib.setLibroID(rs.getInt("LibroID"));
		lib.setAutor(rs.getString("Autor"));
		lib.setEstado(rs.getString("Estado"));
		lib.setFechaPublicacion(rs.getString("FechaPublicacion"));
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