package br.ucsal.gcm.vhshop.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.gcm.vhshop.model.Tape;
import br.ucsal.gcm.vhshop.model.enuns.TapeGender;

public interface TapeRepository extends JpaRepository<Tape, UUID>{
	
	Optional<Tape> findById(UUID id);
	
	Tape findByCode(String code);
	
	Tape findByName(String name);

	Tape findByGender(TapeGender gender);
	
}
