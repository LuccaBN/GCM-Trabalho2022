package br.ucsal.gcm.vhshop.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gcm.vhshop.model.Role;

public interface RoleRepository extends JpaRepository<Role, UUID>{
		Role findIdByname(String name);
}
