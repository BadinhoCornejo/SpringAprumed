package sowad.aprumed.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sowad.aprumed.model.Usuario;
import sowad.aprumed.model.Venta;

public class VentaMapper implements RowMapper<Venta>{
	
	public Venta mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Venta venta = new Venta();
		venta.setEstado(rs.getString("EstadoVenta"));
		venta.setFechaVenta(rs.getString("FechaVenta"));
		venta.setHoraVenta(rs.getString("HoraVenta"));
		venta.setVentaID(rs.getInt("VentaID"));
		
		Usuario usuario = new UsuarioMapper().mapRow(rs, rowNum);
		venta.setUsuario(usuario);
		
		return venta;
	}

}
