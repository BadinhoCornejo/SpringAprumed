package sowad.aprumed.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sowad.aprumed.model.Ejemplar;
import sowad.aprumed.model.Libro;

public class EjemplarMapper implements RowMapper<Ejemplar> {
	
	public Ejemplar mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ejemplar ejemplar = new Ejemplar();
		ejemplar.setEjemplarID(rs.getInt("EjemplarID"));
		ejemplar.setEstado(rs.getString("EstadoEjemplar"));
		ejemplar.setSku(rs.getString("Sku"));
		
		Libro lib = new LibrosMapper().mapRow(rs, rowNum);
		
		ejemplar.setLibro(lib);
		
		return ejemplar;
	}
}
