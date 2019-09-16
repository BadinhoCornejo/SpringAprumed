package sowad.aprumed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ventas")
public class VentaController {

	@RequestMapping(value = "/")
	public String mostrarUsuarios(Model model) {

		return "ventas/ventas";

	}

}
