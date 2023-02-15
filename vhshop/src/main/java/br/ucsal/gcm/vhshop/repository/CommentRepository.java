package br.ucsal.gcm.vhshop.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gcm.vhshop.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID>{
	
	Comment findByUser(UUID id);
	
}
