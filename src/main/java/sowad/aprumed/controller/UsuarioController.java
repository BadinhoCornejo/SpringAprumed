package sowad.aprumed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sowad.aprumed.dao.TipoUsuarioDao;
import sowad.aprumed.dao.UsuarioDao;
import sowad.aprumed.model.TipoUsuario;
import sowad.aprumed.model.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	@Qualifier(value = "tipdao")
	private TipoUsuarioDao tipoUsuarioDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarUsuarios(Model model) {
		List<Usuario> users = new ArrayList<Usuario>();
		List<TipoUsuario> tipUsrs = getTiposUsr();

		try {

			users = usuarioDao.mostrarUsuarios();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VUsers", users);
		model.addAttribute("VTipoUsrs", getOptions(tipUsrs));

		return "usuarios/usuarios";

	}

	@RequestMapping(value = "/filtrar", method = RequestMethod.POST)
	public String filtrarUsuarios(@RequestParam("tipoUsr") String tipoUsr, Model model) {
		List<Usuario> users = new ArrayList<Usuario>();
		List<TipoUsuario> tipUsrs = getTiposUsr();
		try {

			users = usuarioDao.mostrarUsuarios();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		List<Usuario> filteredUsers = new ArrayList<Usuario>();

		for (Usuario usuario : users) {
			TipoUsuario tipo = usuario.getTipoUsuario();
			if (tipoUsr.equals("Todos")) {
				filteredUsers.add(usuario);
			} else if (tipo.getNombreTipoUsuario().equals(tipoUsr)) {
				filteredUsers.add(usuario);
			}
		}

		model.addAttribute("VUsers", filteredUsers);
		model.addAttribute("VTipoUsrs", getOptions(tipUsrs));

		return "usuarios/usuarios";

	}

	@GetMapping("/nuevoUsuario")
	public String nuevoUsuario(Model model) {

		List<TipoUsuario> tipUsrs = getTiposUsr();
		model.addAttribute("VTipoUsrs", tipUsrs);

		return "usuarios/nuevoUsuario";
	}

	@PostMapping(value = "/crear")
	public String crearUsuario(Usuario usuario, @RequestParam("usr_apellido") String apellido,
			@RequestParam("usr_nombre") String nombre, @RequestParam("usr_phone") String telefono,
			@RequestParam("usr_dni") String dni, @RequestParam("tipo_usr") String tipoUsr,
			@RequestParam("sex") String sexo) {

		try {
			Usuario usr = new Usuario();
			usr.setApellido(apellido);
			usr.setNombre(nombre);
			usr.setTelefono(telefono);
			usr.setDni(dni);
			usr.setSexo(sexo);
			
			TipoUsuario tipoUsuario = tipoUsuarioDao.buscarTipoUsuario(tipoUsr);
			
			usr.setTipoUsuario(tipoUsuario);
			
			usuarioDao.crearUsuario(usr);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return "usuarios/nuevoUsuario";
	}

	// --------------------------------Utiles-------------------------

	public List<TipoUsuario> getTiposUsr() {
		List<TipoUsuario> tipUsrs = new ArrayList<TipoUsuario>();
		try {
			tipUsrs = tipoUsuarioDao.mostrarTiposUsuario();

		} catch (Exception e) {
			System.err.println(e.toString());
		}

		return tipUsrs;
	}

	public List<String> getOptions(List<TipoUsuario> tipUsrs) {
		List<String> options = new ArrayList<String>();
		options.add("Todos");
		for (TipoUsuario item : tipUsrs) {
			options.add(item.getNombreTipoUsuario());
		}

		return options;
	}
}
