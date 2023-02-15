package br.ucsal.gcm.vhshop.authentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.gcm.vhshop.model.Tape;
import br.ucsal.gcm.vhshop.model.enuns.TapeStatus;
import br.ucsal.gcm.vhshop.repository.TapeRepository;

@Service
public class DeliverRentedTapeService {

  @Autowired
  TapeRepository tapeRepository;

  public Tape execute(Tape tape) {

    Optional<Tape> tapeExists = tapeRepository.findById(tape.getId());

    if (tapeExists.isEmpty()) {
      throw new Error("Tape does not exists!");
    }
    
    if (tapeExists.get().isAvailable()) {
    	throw new Error("Tape isn't with any User! It was already delivered.");
	}

    Tape tapes = tapeExists.get();

    tapes.setStatus(TapeStatus.AVAILABLE);

    tapeRepository.save(tapes);

    return tapes;

  }
}
