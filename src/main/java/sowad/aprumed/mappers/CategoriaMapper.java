package sowad.aprumed.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sowad.aprumed.model.Categoria;

public class CategoriaMapper implements RowMapper<Categoria>{

	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria cat = new Categoria();
		cat.setCategoriaID(rs.getInt("CategoriaID"));
		cat.setNombreCategoria(rs.getString("NombreCategoria"));
		cat.setEstado(rs.getString("Estado"));

		return cat;
	}
}
