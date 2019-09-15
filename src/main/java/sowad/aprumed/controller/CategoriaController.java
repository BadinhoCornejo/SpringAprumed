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
import sowad.aprumed.model.TipoUsuario;
import sowad.aprumed.model.Usuario;

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
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		model.addAttribute("VCategorias",categorias);

		return "categorias/categorias";

	}
	
	@GetMapping(value = "/nuevaCategoria")
	public String crearCategoria(Model model) {
		List<Categoria> listaCate = getCategoria();
		model.addAttribute("VCates", listaCate);

		return "categorias/nuevaCategoria";
	}
	@PostMapping(value="/nuevo")
	public ModelAndView crearCategoria(Categoria categoria,@RequestParam("cat_nombre") String nombre,
			@RequestParam("cat_estado") String estado) {
		ModelAndView mv = new ModelAndView("categoria/crearCate");
		mv.addObject("cat_nombre", nombre);
		try {
			Categoria cat=new Categoria();
			cat.setNombreCategoria(nombre);
			cat.setEstado(estado);
			
			categoriaDao.insertarCategoria(cat);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return mv;
	}
	@RequestMapping(value = "/categorias/editar", method = RequestMethod.GET, params = {"id"})
	public String editarCategoria(Model model, @RequestParam(value = "id", required = true) int id) {
		
		Categoria cat = categoriaDao.buscarCategoria(id);
		
		List<Categoria> cats = getCategoria();
		
		model.addAttribute("VCategorias", cats);
		model.addAttribute("cat", cat);

		return "categorias/editarCat";
	}
	@PostMapping(value="/editarCate")
	public String editarCategoria(Categoria categoria, @RequestParam("cat_nombre") String nombre, Model model) {
		List<Categoria> cates = new ArrayList<Categoria>();
		Categoria temp = categoriaDao.buscarCategoria(categoria.getCategoriaID());
		try {
			Categoria cat = new Categoria();
			cat.setNombreCategoria(nombre);
			categoriaDao.editarCategoria(cat);
			cates = categoriaDao.mostrarCategorias();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		model.addAttribute("VCategoria", cates);
		return "categorias/categorias";
	}
	@RequestMapping(value="/categorias/eliminar", method = RequestMethod.GET, params = {"id"})
	public String elimnarCategoria(Model model,@RequestParam(value = "id", required = true) int id){
		Categoria cat= categoriaDao.buscarCategoria(id);
		List<Categoria> cats = new ArrayList<Categoria>();
		try {
			categoriaDao.eliminarCategoria(cat);
			cats = categoriaDao.mostrarCategorias();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		model.addAttribute("VCategorias", cats);
		return "categorias/categorias";
	}
	
	public List<Categoria> getCategoria(){
		List<Categoria> cates = new ArrayList<Categoria>();
			try {
				cates = categoriaDao.mostrarCategorias();
			}catch(Exception e) {
				System.err.println(e.toString());
			}
			return cates;
		}
}
	
