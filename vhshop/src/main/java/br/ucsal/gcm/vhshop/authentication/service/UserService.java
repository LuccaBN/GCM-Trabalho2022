package br.ucsal.gcm.vhshop.authentication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ucsal.gcm.vhshop.authentication.service.DTO.CreateUserRoleDTO;
import br.ucsal.gcm.vhshop.model.Role;
import br.ucsal.gcm.vhshop.model.User;
import br.ucsal.gcm.vhshop.repository.RoleRepository;
import br.ucsal.gcm.vhshop.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  RoleRepository roleRepository;
  
  @Autowired
  CreateRoleUserService createRoleUserService;
  
  private BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
  }
  
  // Cria um novo usuario.
  public User execute(User user) {

	    User existsUser = userRepository.findByUsername(user.getUsername());

	    if (existsUser != null) {
	      throw new Error("User already exists!");
	    }
	     
	    user.setPassword(passwordEncoder().encode(user.getPassword()));
	    
	    /*
	    //Verificar se faz sentido.
	    CreateUserRoleDTO dto = new CreateUserRoleDTO();
	    List<Role> rolelistList = new ArrayList<>();
	    List<UUID> roleUuids = new ArrayList<>();
	    
	    Role role = roleRepository.findIdByname("USER");
	    rolelistList.add(role);
	    roleUuids.add(role.getId());
	    
	    dto.setIdUser(user.getId());
	    dto.setIdsRoles(roleUuids); 
	    
	    createRoleUserService.execute(dto);
	    */
	    
	    User createdUser = userRepository.save(user);

	    return createdUser;
	  }
  

  public List<User> listAll(){
	  return userRepository.findAll();
  }
  
  public Boolean existsById(UUID id) {
		return userRepository.existsById(id);
	}

	public void deleteById(UUID id) {
		userRepository.deleteById(id);
	}
	
	public Optional<User> findById(UUID id) {
		return userRepository.findById(id);
	}
  
}