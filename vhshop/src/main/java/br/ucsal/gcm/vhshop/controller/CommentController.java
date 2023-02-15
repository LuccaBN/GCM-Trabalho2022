package br.ucsal.gcm.vhshop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.ucsal.gcm.vhshop.authentication.service.CreateTapeCommentService;
import br.ucsal.gcm.vhshop.authentication.service.DTO.CreateTapeCommentDTO;
import br.ucsal.gcm.vhshop.model.Comment;

//TODO Completar.
@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	CreateTapeCommentService createTapeCommentService;

	@PostMapping("/create")
	public Comment create(CreateTapeCommentDTO createTapeCommentDTO) {
		return createTapeCommentService.execute(createTapeCommentDTO);	
	}
	
	@GetMapping("/list")
	public List<Comment> list(){
		return createTapeCommentService.listAll();
	}
}
















