package br.ucsal.gcm.vhshop.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.ucsal.gcm.vhshop.model.enuns.TapeGender;
import br.ucsal.gcm.vhshop.model.enuns.TapeStatus;

@Entity
@Table(name = "tapes")
public class Tape {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;
	
	private String code;
	
	private TapeStatus status;
	
	private TapeGender gender;
	
	@ManyToMany
	private List<User> users;
		
	public Tape() {
		super();
	}
	
	public Tape(UUID id, String name, String code, TapeStatus status, TapeGender gender, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.status = status;
		this.gender = gender;
		this.users = users;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TapeStatus getStatus() {
		return status;
	}

	public void setStatus(TapeStatus status) {
		this.status = status;
	}
	
	public TapeGender getGender() {
		return gender;
	}
	
	public void setGender(TapeGender gender) {
		this.gender = gender;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public boolean isRented() {
		if (getStatus() == TapeStatus.RENTED) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isAvailable() {
		if (getStatus() == TapeStatus.AVAILABLE) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, id, name, status, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tape other = (Tape) obj;
		return Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& status == other.status && Objects.equals(users, other.users);
	}

}
