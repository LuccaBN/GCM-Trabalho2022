package br.ucsal.gcm.vhshop.authentication.service.DTO;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CreateTapeRentDTO {

	private UUID idTape;

	private List<UUID> idsUsers;

	public UUID getIdTape() {
		return idTape;
	}

	public void setIdTape(UUID idUser) {
		this.idTape = idUser;
	}

	public List<UUID> getIdsUsers() {
		return idsUsers;
	}

	public void setIdsUsers(List<UUID> idsRoles) {
		this.idsUsers = idsRoles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTape, idsUsers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateTapeRentDTO other = (CreateTapeRentDTO) obj;
		return Objects.equals(idTape, other.idTape) && Objects.equals(idsUsers, other.idsUsers);
	}
	
	
}