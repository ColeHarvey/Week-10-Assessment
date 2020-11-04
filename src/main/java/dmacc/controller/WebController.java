package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Voter;
import dmacc.repository.VotingRepository;

@Controller
public class WebController {
	@Autowired
	VotingRepository repo;
	
	@GetMapping({ "/", "/viewAll"})
	public String viewAllVoters(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewVoter(model);
		}
		model.addAttribute("voters", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputVoter")
	public String addNewVoter(Model model) {
	Voter c = new Voter();
	model.addAttribute("newVoter", c);
	return "input";
	}
	
	@PostMapping("/inputVoter")
	public String addNewVoter(@ModelAttribute Voter c,Model model) {
	repo.save(c);
	return viewAllVoters(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateVoters(@PathVariable("id") long id,Model model) {
	Voter c = repo.findById(id).orElse(null);
	model.addAttribute("newVoter", c);
	return "input";
	}
	
	@PostMapping("/update/{id}")
	public
	String reviseVoters(Voter c, Model model) {
	repo.save(c);
	return viewAllVoters(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	Voter c = repo.findById(id).orElse(null);
	repo.delete(c);
	return viewAllVoters(model);
	}
}

