package br.ucsal.gcm.vhshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.gcm.vhshop.authentication.service.CreateRoleUserService;
import br.ucsal.gcm.vhshop.authentication.service.UserService;
import br.ucsal.gcm.vhshop.authentication.service.DTO.CreateUserRoleDTO;
import br.ucsal.gcm.vhshop.model.User;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	CreateRoleUserService createRoleUserService;

	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return userService.execute(user);
	}

	@PostMapping("/assign")
	public User role(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
		return createRoleUserService.execute(createUserRoleDTO);
	}
	
	@GetMapping("/list")
	public List<User> list(){
		return userService.listAll();
	}
}