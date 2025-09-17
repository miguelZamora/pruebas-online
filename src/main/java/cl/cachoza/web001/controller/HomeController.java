package cl.cachoza.web001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/")
public class HomeController {

	
	
	@GetMapping(path={"/home","/"})
	public String home(Model model) {
		
		model.addAttribute("mensaje", "Hola mundo en java Thymeleaf");
        return "home"; 
        // ← Devuelve nombre de vista (Thymeleaf, JSP, etc.)
    }
	
	
	
	
	
	
	
}
