package sowad.aprumed.dao;

import java.util.List;

import sowad.aprumed.model.Usuario;

public interface UsuarioDao {
	public int crearUsuario(Usuario usuario);
	public int eliminarUsuario(Usuario usuario);
	public int editarUsuario(Usuario usuario);
	public Usuario buscarUsuarioCuenta(String Dni);
	public Usuario buscarUsuario(String Dni);
	public List<Usuario> mostrarUsuarios();
}
