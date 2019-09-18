package sowad.aprumed.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sowad.aprumed.dao.ComprobantePagoDao;
import sowad.aprumed.dao.EjemplarDao;
import sowad.aprumed.dao.LibroDao;
import sowad.aprumed.dao.LineaVentaDao;
import sowad.aprumed.dao.UsuarioDao;
import sowad.aprumed.dao.VentaDao;
import sowad.aprumed.model.ComprobantePago;
import sowad.aprumed.model.Ejemplar;
import sowad.aprumed.model.Libro;
import sowad.aprumed.model.LineaVenta;
import sowad.aprumed.model.Usuario;
import sowad.aprumed.model.Venta;

@Controller
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private VentaDao ventaDao;

	@Autowired
	@Qualifier(value = "linventa")
	private LineaVentaDao lineaventaDao;

	@Autowired
	@Qualifier(value = "cp")
	private ComprobantePagoDao comprobantePagoDao;

	@Autowired
	@Qualifier(value = "lbrventa")
	private LibroDao libroVentaDao;

	@Autowired
	@Qualifier(value = "ejemplarventa")
	private EjemplarDao ejemplarVentaDao;

	@Autowired
	@Qualifier(value = "usrventa")
	private UsuarioDao usrdaoventa;

	@RequestMapping(value = "/")
	public String mostrarUsuarios(Model model) {

		List<Venta> ventas = new ArrayList<Venta>();

		try {
			ventas = ventaDao.mostrarVentas();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("Vventas", ventas);

		return "ventas/ventas";

	}

	@RequestMapping(value = "/buscarLibro", method = RequestMethod.POST)
	public String results(@RequestParam("parameter") String parameter, Model model) {

		List<Ejemplar> results = new ArrayList<Ejemplar>();

		try {

			results = libroVentaDao.buscarLibroEjemplar(parameter);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("VEjemplar", results);

		return "ventas/results";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET, params = { "sku" })
	public String agregarVenta(Model model, @RequestParam(value = "sku", required = true) String sku) {
		
		model.addAttribute("sku", sku);
		
		return "ventas/ventaUsuario";
	}

	@PostMapping(value = "/crearVenta")
	public String crearVenta(Model model, @RequestParam("sku") String sku, @RequestParam("dni") String dni) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Date fecha = new Date();

		Usuario usr = new Usuario();
		Venta venta = new Venta();
		Ejemplar ejemplar = new Ejemplar();

		try {

			usr = usrdaoventa.buscarUsuario(dni);

			venta.setEstado("Activo");
			venta.setFechaVenta(format.format(fecha));
			venta.setHoraVenta(df.format(fecha));
			venta.setUsuario(usr);

			int ventaResult = ventaDao.crearVenta(venta);
			
			System.out.println("1:"+ventaResult);
			
			if (ventaResult > 0) {
				System.out.println("2:"+sku);
				ejemplar = ejemplarVentaDao.buscarEjemplar(sku);
				System.out.println("3:"+ejemplar.getEjemplarID());
				Venta ventaUsuario = ventaDao.buscarVentaUsuario(dni);
				System.out.println("4:"+ventaUsuario.getVentaID());
				int lvResult = lineaventaDao.agregarLineaVenta(ejemplar, ventaUsuario);

				if (lvResult > 0) {
					
					ejemplarVentaDao.vendido(ejemplar.getEjemplarID());
					Libro libro = libroVentaDao.getLibroById(ejemplar.getLibro().getLibroID());
					
					libro.quitStock();
					libroVentaDao.actualizarStock(libro);

					crearComprobante(format.format(fecha), df.format(fecha), libro, ventaUsuario);
					
					ventaDao.setRealizada(ventaUsuario.getVentaID());
					
				}

			}

		} catch (Exception e) {
			System.err.println(e.toString());
		}

		return "ventas/success";
	}

	@RequestMapping(value = "/anular", method = RequestMethod.GET, params = { "id" })
	public String anularVenta(Model model, @RequestParam(value = "id", required = true) int id) {
		List<Venta> ventas = new ArrayList<Venta>();
		
		try {
			
			ventaDao.setInactiva(id);
			
			ventas = ventaDao.mostrarVentas();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		model.addAttribute("Vventas", ventas);

		return "ventas/ventas";
	}

	public int crearComprobante(String fecha, String hora, Libro libro, Venta venta) {
		ComprobantePago comprobantePago = new ComprobantePago();
		comprobantePago.setFechaCp(fecha);
		comprobantePago.setHoraCp(hora);
		comprobantePago.setSubtotal(libro.getPrecio());
		comprobantePago.setRuc("20554394273");
		comprobantePago.setVenta(venta);

		return comprobantePagoDao.crearComprobante(comprobantePago);
	}

}
