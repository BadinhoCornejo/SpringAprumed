package sowad.aprumed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goDashboard() {
		return "dashboard";
	}
	
}
