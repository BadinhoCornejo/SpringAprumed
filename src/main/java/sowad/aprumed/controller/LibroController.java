package sowad.aprumed.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import sowad.aprumed.dao.CategoriaDao;
import sowad.aprumed.dao.EjemplarDao;
import sowad.aprumed.dao.LibroDao;
import sowad.aprumed.dao.TipoUsuarioDao;
import sowad.aprumed.model.Categoria;
import sowad.aprumed.model.Ejemplar;
import sowad.aprumed.model.Libro;
import sowad.aprumed.model.TipoUsuario;

@Controller
@RequestMapping("/libros")
public class LibroController {
	@Autowired
	private LibroDao libroDao;
	
	@Autowired
	@Qualifier(value = "catdaolbr")
	private CategoriaDao categoriaDaoLbr;

	@Autowired
	@Qualifier(value = "ejemplardao")
	private EjemplarDao ejemplarDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarLibros(Model model) {
		List<Libro> libros = new ArrayList<Libro>();
		try {

			libros = libroDao.mostrarLibros();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VLibros", libros);

		return "libros/libros";

	}

	@GetMapping("/nuevoLibro")
	public String nuevoUsuario(Model model) {

		List<Categoria> categorias = categoriaDaoLbr.mostrarCategorias();

		model.addAttribute("VCategorias", categorias);

		return "libros/nuevoLibro";
	}

	@PostMapping(value = "/crear")
	public String crearLibro(Libro libro, Model model, @RequestParam("lbr_autor") String autor,
			@RequestParam("lbr_titulo") String titulo, @RequestParam("lbr_isbn") String isbn,
			@RequestParam("lbr_date") String date, @RequestParam("lbr_cat") String categoria,
			@RequestParam("lbr_precio") Double precio) {

		List<Libro> libros = new ArrayList<Libro>();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

		try {

			Libro lbr = new Libro();

			lbr.setAutor(autor);
			lbr.setTitulo(titulo);
			lbr.setIsbn(isbn);
			lbr.setFechaPublicacion(date);
			lbr.setEstado("Activo");
			lbr.setStock(0);
			lbr.setPrecio(precio);

			Categoria cat = categoriaDaoLbr.buscarCategoria(categoria);

			lbr.setCategoria(cat);

			libroDao.crearLibro(lbr);

			libros = libroDao.mostrarLibros();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VLibros", libros);
		return "libros/libros";
	}

	@RequestMapping(value = "/libros/delete", method = RequestMethod.GET, params = { "id" })
	public String eliminarLibro(Model model, @RequestParam(value = "id", required = true) int id) {
		List<Libro> libros = new ArrayList<Libro>();

		try {

			libroDao.eliminarLibro(id);
			libros = libroDao.mostrarLibros();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VLibros", libros);

		return "libros/libros";
	}

	@RequestMapping(value = "/libros/update", method = RequestMethod.GET, params = { "id" })
	public String editarLibro(Model model, @RequestParam(value = "id") int id) {

		List<Categoria> categorias = new ArrayList<Categoria>();
		Libro libro = new Libro();

		try {

			categorias = categoriaDaoLbr.mostrarCategorias();
			libro = libroDao.getLibroById(id);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VCategorias", categorias);
		model.addAttribute("libro", libro);

		return "libros/editarLibro";
	}

	@PostMapping(value = "/editLibro")
	public String editLibro(Libro libro, Model model, @RequestParam("id") int id,
			@RequestParam("lbr_autor") String autor, @RequestParam("lbr_titulo") String titulo,
			@RequestParam("lbr_isbn") String isbn, @RequestParam("lbr_date") String date,
			@RequestParam("lbr_cat") String categoria, @RequestParam("lbr_precio") Double precio,
			@RequestParam("estado") String estado) {

		List<Libro> libros = new ArrayList<Libro>();

		try {

			Libro temp = libroDao.getLibroById(id);

			Libro lbr = new Libro();

			lbr.setLibroID(temp.getLibroID());
			lbr.setAutor(autor);
			lbr.setTitulo(titulo);
			lbr.setIsbn(isbn);
			lbr.setPrecio(precio);
			lbr.setEstado(estado);
			
			System.out.println(date);
			
			lbr.setFechaPublicacion(date);

			Categoria cate = categoriaDaoLbr.buscarCategoria(categoria);

			lbr.setCategoria(cate);

			libroDao.editarLibro(lbr);

			libros = libroDao.mostrarLibros();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VLibros", libros);
		return "libros/libros";
	}
	
	@RequestMapping(value = "/libros/addEjemplar", method = RequestMethod.GET, params = { "id" })
	public String agregarEjemplar(Model model, @RequestParam(value = "id") int id) {

		Libro libro = new Libro();

		try {

			libro = libroDao.getLibroById(id);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("libro", libro);

		return "libros/agregarEjemplar";
	}
	
	@PostMapping(value = "/crearEjemplar")
	public String agregarEjemplar(Libro libro, Model model, @RequestParam("id") int id,@RequestParam("sku") String sku) {

		List<Libro> libros = new ArrayList<Libro>();

		try {

			Libro lbr = libroDao.getLibroById(id);

			Ejemplar ejemplar = new Ejemplar();
			ejemplar.setLibro(lbr);
			ejemplar.setSku(sku);
			ejemplar.setEstado("En almacen");
			
			ejemplarDao.crearEjemplar(ejemplar);
			
			lbr.addStock();
			
			libroDao.actualizarStock(lbr);

			libros = libroDao.mostrarLibros();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VLibros", libros);
		return "libros/libros";
	}

}
