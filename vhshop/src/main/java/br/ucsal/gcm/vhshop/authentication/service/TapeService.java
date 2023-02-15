package br.ucsal.gcm.vhshop.authentication.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.gcm.vhshop.model.Tape;
import br.ucsal.gcm.vhshop.repository.TapeRepository;

@Service
public class TapeService {
	
	@Autowired
	TapeRepository tapeRepository;
	
	public Tape execute(Tape tape) {
		
		Tape existsTapeCode = tapeRepository.findByCode(tape.getCode());
		Tape existsTapeName = tapeRepository.findByName(tape.getName());
		Tape existsTapeGender = tapeRepository.findByGender(tape.getGender());
		
		 if (existsTapeCode != null && existsTapeName != null && existsTapeGender != null) {
		      throw new Error("Tape already exists!");
		    }
		    
		    Tape createdTape = tapeRepository.save(tape);
 
		    return createdTape;
		
	}
	
	public Boolean existsById(UUID id) {
		return tapeRepository.existsById(id);
	}
	
	public List<Tape> listAll(){
		return tapeRepository.findAll();
	}

	public void deleteById(UUID id) {
		tapeRepository.deleteById(id);
	}
	
	public Optional<Tape> findById(UUID id) {
		return tapeRepository.findById(id);
	}
	
}
