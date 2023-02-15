package br.ucsal.gcm.vhshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.gcm.vhshop.authentication.service.UserService;
import br.ucsal.gcm.vhshop.model.User;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("")
	public String index() { 
		return "redirect:/tapes"; 
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "html/signin";
	}
	
	@PostMapping("/logar")
	public String logar(Model model, User userParam) {
		return "redirect:/tapes"; 
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "html/register";
	}
	 
	@PostMapping("/registrar")
	public String registrar(User user) {
		
		userService.execute(user);

		return "redirect:/login";

	}

}
