package br.ucsal.gcm.vhshop.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ucsal.gcm.vhshop.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

  User findByUsername(String username);
  
  @Query("SELECT u from User u JOIN FETCH u.roles where u.username = :username")
  User findByUsernameFetchRoles(@Param("username") String username);

  Optional<User> findById(UUID id);
}