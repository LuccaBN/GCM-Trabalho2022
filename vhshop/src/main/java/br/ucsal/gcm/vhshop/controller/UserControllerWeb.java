package br.ucsal.gcm.vhshop.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.ucsal.gcm.vhshop.authentication.service.CreateRoleUserService;
import br.ucsal.gcm.vhshop.authentication.service.DeliverRentedTapeService;
import br.ucsal.gcm.vhshop.authentication.service.UserService;
import br.ucsal.gcm.vhshop.model.User;

@Controller
public class UserControllerWeb {

	@Autowired
	UserService userService;

	@Autowired
	CreateRoleUserService createRoleUserService;

	@Autowired
	DeliverRentedTapeService deliverRentedTapeService;
		
	//Listar fitas
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/users")
	public String listUserString(Model model) {
		List<User> userList = userService.listAll();
		model.addAttribute("userList", userList);
		return "html/user"; //Refere-se ao HTML que precisa ser devolvido.
	}
	
	//Adicionar fita equiv
	@GetMapping("/users/add")
	public String add(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "html/cadastrousuario";
	}
	
	//Salvar fitas
	@PostMapping("/users/save")
	public String save(User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return"/html/cadastrousuarios"; //Se der erro volta para a página de add.
		}
		userService.execute(user);
		return "redirect:/users";
	}
	
	@GetMapping("/users/{id}")
	  public String search(@PathVariable UUID id, Model model){
	    Optional<User> user = userService.findById(id);
	    try{
	      model.addAttribute("user", user.get());
	    }
	    catch(Exception err){ return "redirect:/users"; }

	    return "html/edituserform";
	  }
  
	@PostMapping("/users/{id}/update")
	  public String update(@PathVariable UUID id, User user){
	    // if(!repo.exist(id)){
	    if(!userService.existsById(id)){
	      return "redirect:/users";
	    }

	    userService.execute(user);

	    return "redirect:/users";
	  }


	  @GetMapping("/users/{id}/delete")
	  public String delete(@PathVariable UUID id){
	    userService.deleteById(id);
	    return "redirect:/users";
	  }

}
