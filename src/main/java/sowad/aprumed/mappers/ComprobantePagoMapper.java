package sowad.aprumed.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sowad.aprumed.model.ComprobantePago;
import sowad.aprumed.model.Venta;

public class ComprobantePagoMapper implements RowMapper<ComprobantePago>{
	
	public ComprobantePago mapRow(ResultSet rs, int rowNum) throws SQLException {
		ComprobantePago cp = new ComprobantePago();
		cp.setFechaCp(rs.getString("FechaCp"));
		cp.setHoraCp(rs.getString("HoraCp"));
		cp.setRuc(rs.getString("Ruc"));
		cp.setSubtotal(rs.getDouble("Subtotal"));
		cp.setComprobantePagoID(rs.getInt("ComprobantePagoID"));
		
		Venta venta = new Venta();
		venta.setEstado(rs.getString("Estado"));
		venta.setFechaVenta(rs.getString("FechaVenta"));
		venta.setHoraVenta(rs.getString("HoraVenta"));
		venta.setVentaID(rs.getInt("VentaID"));
		
		cp.setVenta(venta);

		return cp;
	}

}
