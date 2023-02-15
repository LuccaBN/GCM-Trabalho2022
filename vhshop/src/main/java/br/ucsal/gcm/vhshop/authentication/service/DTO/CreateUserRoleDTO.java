package br.ucsal.gcm.vhshop.authentication.service.DTO;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CreateUserRoleDTO {

	private UUID idUser;

	private List<UUID> idsRoles;

	public UUID getIdUser() {
		return idUser;
	}

	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}

	public List<UUID> getIdsRoles() {
		return idsRoles;
	}

	public void setIdsRoles(List<UUID> idsRoles) {
		this.idsRoles = idsRoles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUser, idsRoles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateUserRoleDTO other = (CreateUserRoleDTO) obj;
		return Objects.equals(idUser, other.idUser) && Objects.equals(idsRoles, other.idsRoles);
	}
	
	
}