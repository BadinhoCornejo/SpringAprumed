package sowad.aprumed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sowad.aprumed.dao.CategoriaDao;
import sowad.aprumed.model.Categoria;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaDao categoriaDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarLibros(Model model) {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {

			categorias = categoriaDao.mostrarCategorias();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VCategorias", categorias);

		return "categorias/categorias";

	}

	@GetMapping(value = "/nuevaCategoria")
	public String crearCategoria(Model model) {

		return "categorias/nuevaCategoria";
	}

	@PostMapping(value = "/crear")
	public String crearCategoria(Categoria categoria, @RequestParam("cat_nombre") String nombre, Model model) {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			Categoria cat = new Categoria();
			cat.setNombreCategoria(nombre);
			cat.setEstado("Activo");

			categoriaDao.insertarCategoria(cat);

			categorias = categoriaDao.mostrarCategorias();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VCategorias", categorias);
		return "categorias/categorias";
	}

	@RequestMapping(value = "/categorias/update", method = RequestMethod.GET, params = { "cat_nombre" })
	public String editarCategoria(Model model, @RequestParam(value = "cat_nombre", required = true) String nombre) {

		Categoria cat = categoriaDao.buscarCategoria(nombre);

		model.addAttribute("cat", cat);

		return "categorias/editarCategoria";
	}

	@PostMapping(value = "/editCate")
	public String editarCategoria(Categoria categoria, @RequestParam("cat_nombre") String nombre,
			@RequestParam("estado") String estado, Model model) {
		List<Categoria> cates = new ArrayList<Categoria>();
		Categoria temp = categoriaDao.buscarCategoria(nombre);
		try {
			Categoria cat = new Categoria();
			cat.setNombreCategoria(nombre);
			cat.setEstado(estado);
			cat.setCategoriaID(temp.getCategoriaID());
			categoriaDao.editarCategoria(cat);
			cates = categoriaDao.mostrarCategorias();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		model.addAttribute("VCategorias", cates);
		return "categorias/categorias";
	}

	@RequestMapping(value = "/categorias/delete", method = RequestMethod.GET, params = { "cat_nombre" })
	public String elimnarCategoria(Model model, @RequestParam(value = "cat_nombre", required = true) String nombre) {
		Categoria cat = categoriaDao.buscarCategoria(nombre);
		List<Categoria> cats = new ArrayList<Categoria>();
		try {
			categoriaDao.eliminarCategoria(cat);
			cats = categoriaDao.mostrarCategorias();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		model.addAttribute("VCategorias", cats);
		return "categorias/categorias";
	}

	public List<Categoria> getCategoria() {
		List<Categoria> cates = new ArrayList<Categoria>();
		try {
			cates = categoriaDao.mostrarCategorias();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return cates;
	}
}
