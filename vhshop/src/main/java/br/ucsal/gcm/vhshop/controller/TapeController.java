package br.ucsal.gcm.vhshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.gcm.vhshop.authentication.service.CreateRentTapeService;
import br.ucsal.gcm.vhshop.authentication.service.DeliverRentedTapeService;
import br.ucsal.gcm.vhshop.authentication.service.TapeService;
import br.ucsal.gcm.vhshop.authentication.service.DTO.CreateTapeRentDTO;
import br.ucsal.gcm.vhshop.model.Tape;

@RestController
@RequestMapping("/api/tapes")
public class TapeController {

	@Autowired
	TapeService tapeService;

	@Autowired
	CreateRentTapeService createRentTapeService;

	@Autowired
	DeliverRentedTapeService deliverRentedTapeService;

	@PostMapping("/create")
	public Tape create(@RequestBody Tape tape) {
		return tapeService.execute(tape);
	}

	// TODO FIXED - RENT A TAPE FOR A USER
	@PostMapping("/assign")
	public Tape rent(@RequestBody CreateTapeRentDTO createTapeRentDTO) {
		return createRentTapeService.execute(createTapeRentDTO);
	}

	// TODO FIXED - User delivering a tape
	@PostMapping("/unassign")
	public Tape deliver(@RequestBody Tape tape) {
		return deliverRentedTapeService.execute(tape);
	}

	@GetMapping("/list")
	public List<Tape> list() {
		return tapeService.listAll();
	}
}
