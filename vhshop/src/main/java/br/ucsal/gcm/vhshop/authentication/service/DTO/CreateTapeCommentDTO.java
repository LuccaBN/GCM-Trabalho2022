package br.ucsal.gcm.vhshop.authentication.service.DTO;

import java.util.Objects;
import java.util.UUID;

public class CreateTapeCommentDTO {
	
	private UUID idUser;
	private UUID idComment;
	private UUID idTape;

	public UUID getIdComment() {
		return idComment;
	}
	public void setIdComment(UUID idComment) {
		this.idComment = idComment;
	}
	public UUID getIdTape() {
		return idTape;
	}
	public void setIdTape(UUID idTape) {
		this.idTape = idTape;
	}
	public UUID getIdUser() {
		return idUser;
	}
	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idComment, idTape, idUser);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateTapeCommentDTO other = (CreateTapeCommentDTO) obj;
		return Objects.equals(idComment, other.idComment) && Objects.equals(idTape, other.idTape)
				&& Objects.equals(idUser, other.idUser);
	}
	
}
