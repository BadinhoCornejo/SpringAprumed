package sowad.aprumed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sowad.aprumed.dao.LibroDao;
import sowad.aprumed.model.Libro;
import sowad.aprumed.model.TipoUsuario;

@Controller
@RequestMapping("/libros")
public class LibroController {
	@Autowired
	private LibroDao libroDao;

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

		return "libros/nuevoLibro";
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

}
