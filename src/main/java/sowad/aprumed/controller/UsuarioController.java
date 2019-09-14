package sowad.aprumed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sowad.aprumed.dao.CuentaDao;
import sowad.aprumed.dao.TipoUsuarioDao;
import sowad.aprumed.dao.UsuarioDao;
import sowad.aprumed.model.Cuenta;
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

	@Autowired
	@Qualifier(value = "accdao")
	private CuentaDao cuentaDao;

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
	public ModelAndView crearUsuario(Usuario usuario, @RequestParam("usr_apellido") String apellido,
			@RequestParam("usr_nombre") String nombre, @RequestParam("usr_phone") String telefono,
			@RequestParam("usr_dni") String dni, @RequestParam("tipo_usr") String tipoUsr,
			@RequestParam("sex") String sexo) {

		ModelAndView mv = new ModelAndView("usuarios/crearCuenta");
		mv.addObject("usr_dni", dni);

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

		return mv;
	}

	@RequestMapping(value = "/crearCuenta", method = RequestMethod.GET)
	public String crearCuenta(Model model) {

		return "usuarios/crearCuenta";
	}

	@PostMapping(value = "/crearCuenta")
	public String nuevaCuenta(Cuenta cuenta, @RequestParam("usr_dni") String dni,
			@RequestParam("acc_email") String email, @RequestParam("acc_password") String pass) {

		try {
			Cuenta acc = new Cuenta();
			acc.setEmail(email);
			acc.setUsrPassword(pass);
			acc.setEstado("Activo");

			Usuario usr = usuarioDao.buscarUsuario(dni);

			acc.setUsuario(usr);

			cuentaDao.crearCuenta(acc);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return "usuarios/nuevoUsuario";
	}

	@RequestMapping(value = "/usuarios/delete", method = RequestMethod.GET, params = { "dni" })
	public String eliminarUsuario(Model model, @RequestParam(value = "dni", required = true) String dni) {

		Usuario usr = usuarioDao.buscarUsuario(dni);

		List<Usuario> users = new ArrayList<Usuario>();
		List<TipoUsuario> tipUsrs = getTiposUsr();

		try {
			usuarioDao.eliminarUsuario(usr);
			users = usuarioDao.mostrarUsuarios();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VUsers", users);
		model.addAttribute("VTipoUsrs", getOptions(tipUsrs));

		return "usuarios/usuarios";
	}

	@RequestMapping(value = "/usuarios/update", method = RequestMethod.GET, params = { "id" })
	public String editarUsuario(Model model, @RequestParam(value = "id", required = true) String id) {
		
		Usuario usr = usuarioDao.buscarUsuarioCuenta(id);
		
		model.addAttribute("user", usr);
		model.addAttribute("acc", usr.getCuenta());

		return "usuarios/editarUsuario";
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
