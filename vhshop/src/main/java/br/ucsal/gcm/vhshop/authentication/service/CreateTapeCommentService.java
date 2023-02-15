package br.ucsal.gcm.vhshop.authentication.service;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.gcm.vhshop.authentication.service.DTO.CreateTapeCommentDTO;
import br.ucsal.gcm.vhshop.model.Comment;
import br.ucsal.gcm.vhshop.model.Tape;
import br.ucsal.gcm.vhshop.model.User;
import br.ucsal.gcm.vhshop.repository.CommentRepository;
import br.ucsal.gcm.vhshop.repository.TapeRepository;
import br.ucsal.gcm.vhshop.repository.UserRepository;

@Service
public class CreateTapeCommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	TapeRepository tapeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Comment execute(CreateTapeCommentDTO createTapeCommentDTO) {
		
		Optional<Tape> tapeExists = tapeRepository.findById(createTapeCommentDTO.getIdTape());
		Optional<User> userExists = userRepository.findById(createTapeCommentDTO.getIdUser());
		Optional<Comment> commentExists = commentRepository.findById(createTapeCommentDTO.getIdComment());
		
		// Verifying if Tape exists.
		if (tapeExists.isEmpty()) {
			throw new Error("Tape does not exists!");
		}
		
		
		// Verifying if User ever rented this tape
		Tape tape = tapeExists.get();
		
		
		if (!tape.getUsers().contains(userExists.get())) {
			throw new Error("This user never had this tape before...");
		}
		
		// Executar a ação com DTO
		
		Comment comment = commentExists.get();
		User user = userExists.get();		
		
		comment.setUser(user);
		comment.setTape(tape);

		
		Comment createdComment = commentRepository.save(comment);
		
		return createdComment;
	}
	
	public List<Comment> listAll(){
		return commentRepository.findAll();
	}

}
