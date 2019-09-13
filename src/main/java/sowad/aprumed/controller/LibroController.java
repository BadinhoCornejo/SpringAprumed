package sowad.aprumed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sowad.aprumed.dao.LibroDao;
import sowad.aprumed.model.Libro;

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

		for (Libro libro : libros) {
			System.out.println(libro.getAutor() + libro.getTitulo() + libro.getLibroID());
		}

		model.addAttribute("VLibros", libros);

		return "libros/libros";

	}

}
