package sowad.aprumed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		model.addAttribute("VTipoUsrs", tipUsrs);
		
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
			if(tipo.getNombreTipoUsuario().equals(tipoUsr)) {
				filteredUsers.add(usuario);
			}
		}

		model.addAttribute("VUsers", filteredUsers);
		model.addAttribute("VTipoUsrs", tipUsrs);
		
		return "usuarios/usuarios";

	}
	
	public List<TipoUsuario> getTiposUsr(){
		List<TipoUsuario> tipUsrs = new ArrayList<TipoUsuario>();
		try {
			tipUsrs = tipoUsuarioDao.mostrarTiposUsuario();
			
		} catch (Exception e) {
			System.err.println("error tipUser");
		}
		
		
		return tipUsrs;
	}
}
