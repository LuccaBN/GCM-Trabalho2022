package br.ucsal.gcm.vhshop.authentication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.gcm.vhshop.authentication.service.DTO.CreateTapeRentDTO;
import br.ucsal.gcm.vhshop.model.Tape;
import br.ucsal.gcm.vhshop.model.User;
import br.ucsal.gcm.vhshop.model.enuns.TapeStatus;
import br.ucsal.gcm.vhshop.repository.TapeRepository;

@Service
public class CreateRentTapeService {

  @Autowired
  TapeRepository tapeRepository;

  public Tape execute(CreateTapeRentDTO createTapeRentDTO) {

    Optional<Tape> tapeExists = tapeRepository.findById(createTapeRentDTO.getIdTape());
    List<User> users = new ArrayList<>();

    if (tapeExists.isEmpty()) {
      throw new Error("Tape does not exists!");
    }
    
    if (tapeExists.get().isRented()) {
    	throw new Error("Tape is already Rented!");
	}
    
    users = createTapeRentDTO.getIdsUsers().stream().map(user -> {
      return new User(user);
    }).collect(Collectors.toList());

    Tape tape = tapeExists.get();

    tape.setUsers(users);
    tape.setStatus(TapeStatus.AVAILABLE);

    tapeRepository.save(tape);

    return tape;

  }
}
