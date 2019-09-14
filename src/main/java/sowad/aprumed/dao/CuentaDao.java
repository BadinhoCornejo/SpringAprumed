package sowad.aprumed.dao;

import sowad.aprumed.model.Cuenta;

public interface CuentaDao {
	public int crearCuenta(Cuenta cuenta);
	public int eliminarCuenta(Cuenta cuenta);
	public int editarCuenta(Cuenta cuenta);
}
