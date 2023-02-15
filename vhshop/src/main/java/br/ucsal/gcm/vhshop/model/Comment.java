package br.ucsal.gcm.vhshop.model;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue
	private UUID id;
	
	private String description;
	
	@OneToOne
	private Tape tape;
	
	@OneToOne
	private  User user;

	public Comment(UUID id, String description, Tape tape, User user) {
		super();
		this.id = id;
		this.description = description;
		this.tape = tape;
		this.user = user;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(UUID id) {
		super();
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tape getTape() {
		return tape;
	}

	public void setTape(Tape tape) {
		this.tape = tape;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
