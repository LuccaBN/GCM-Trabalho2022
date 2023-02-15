package br.ucsal.gcm.vhshop.authentication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.gcm.vhshop.authentication.service.DTO.CreateUserRoleDTO;
import br.ucsal.gcm.vhshop.model.Role;
import br.ucsal.gcm.vhshop.model.User;
import br.ucsal.gcm.vhshop.repository.RoleRepository;
import br.ucsal.gcm.vhshop.repository.UserRepository;

@Service
public class CreateRoleUserService {

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  RoleRepository roleRepository;

  public User execute(CreateUserRoleDTO createUserRoleDTO) {

    Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
    List<Role> roles = new ArrayList<>();

    if (userExists.isEmpty()) {
      throw new Error("User does not exists!");
    }

    roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
      return new Role(role);
    }).collect(Collectors.toList());

    User user = userExists.get();

    user.setRoles(roles);

    userRepository.save(user);

    return user;

  }
  
  public Role findIdbyNameRole(Role role) {
	  return roleRepository.findIdByname(role.getName());
  }
}
