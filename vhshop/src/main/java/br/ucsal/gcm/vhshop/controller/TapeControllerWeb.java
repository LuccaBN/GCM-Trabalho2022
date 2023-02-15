package br.ucsal.gcm.vhshop.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.ucsal.gcm.vhshop.authentication.service.CreateRentTapeService;
import br.ucsal.gcm.vhshop.authentication.service.DeliverRentedTapeService;
import br.ucsal.gcm.vhshop.authentication.service.TapeService;
import br.ucsal.gcm.vhshop.model.Tape;

@Controller
public class TapeControllerWeb {
	

	@Autowired
	TapeService tapeService;

	@Autowired
	CreateRentTapeService createRentTapeService;

	@Autowired
	DeliverRentedTapeService deliverRentedTapeService;
	
	//Listar fitas
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/tapes")
	public String listTapeString(Model model) {
		List <Tape> tapeList = tapeService.listAll();
		model.addAttribute("tapeList", tapeList);
		return "html/fitas"; //Refere-se ao HTML que precisa ser devolvido.
	}
	
	//Adicionar fita equiv
	@GetMapping("/tapes/add")
	public String add(Model model) {
		Tape tape = new Tape();
		model.addAttribute("tape", tape);
		return "html/cadastrofitas";
	}
	
	//Salvar fitas
	@PostMapping("/tapes/save")
	public String save(Tape tape, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return"/html/cadastrofitas"; //Se der erro volta para a página de add.
		}
		tapeService.execute(tape);
		return "redirect:/tapes";
	}
	
	@GetMapping("/tapes/{id}")
	  public String search(@PathVariable UUID id, Model model){
	    Optional<Tape> tape = tapeService.findById(id);
	    try{
	      model.addAttribute("tape", tape.get());
	    }
	    catch(Exception err){ return "redirect:/tapes"; }

	    return "html/editform";
	  }
  
	@PostMapping("/tapes/{id}/update")
	  public String update(@PathVariable UUID id, Tape tape){
	    // if(!repo.exist(id)){
	    if(!tapeService.existsById(id)){
	      return "redirect:/tapes";
	    }

	    tapeService.execute(tape);

	    return "redirect:/tapes";
	  }


	  @GetMapping("/tapes/{id}/delete")
	  public String delete(@PathVariable UUID id){
	    tapeService.deleteById(id);
	    return "redirect:/tapes";
	  }
	
//	//Add rent 
//	@PostMapping("/tapes/rent")
//	public Tape rent(Model model, CreateTapeRentDTO createTapeRentDTO) {
//		return createRentTapeService.execute(createTapeRentDTO);
//	} 
//
//	@PostMapping("/deliver")
//	public Tape deliver(Model model, Tape tape) {
//		return deliverRentedTapeService.execute(tape);
//	}
}
