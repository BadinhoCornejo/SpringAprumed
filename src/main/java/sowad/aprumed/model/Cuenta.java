package sowad.aprumed.model;

public class Cuenta {
	private int CuentaID;
	private Usuario Usuario;
	private String Email;
	private String UsrPassword;
	private String Estado;
	public int getCuentaID() {
		return CuentaID;
	}
	public void setCuentaID(int cuentaID) {
		CuentaID = cuentaID;
	}
	public Usuario getUsuario() {
		return Usuario;
	}
	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUsrPassword() {
		return UsrPassword;
	}
	public void setUsrPassword(String usrPassword) {
		UsrPassword = usrPassword;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
}
