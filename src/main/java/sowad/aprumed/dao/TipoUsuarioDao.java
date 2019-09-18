package sowad.aprumed.dao;

import java.util.List;

import sowad.aprumed.model.TipoUsuario;

public interface TipoUsuarioDao {
	public int eliminarTipoUsuario(TipoUsuario tipoUsuario);
	public int editarTipoUsuario(TipoUsuario tipoUsuario);
	public TipoUsuario buscarTipoUsuario(String nombreTipoUsuario);
	public List<TipoUsuario> mostrarTiposUsuario();
}
