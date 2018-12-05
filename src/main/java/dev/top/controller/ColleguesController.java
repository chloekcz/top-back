package dev.top.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VoteRepo;

@CrossOrigin
@RestController()
@RequestMapping("/collegues")
public class ColleguesController {
	
	@Autowired
	private CollegueRepo collegueRepo;
	

	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueRepo.findAll();
	}
	
	@GetMapping("/{pseudo}")
	public Collegue find(@PathVariable String pseudo) {
		return this.collegueRepo.findByPseudo(pseudo);
	}
	
	@PatchMapping("/{pseudo}")
	public Collegue patch(@PathVariable String pseudo, @RequestBody Map<String, String> vote) {
		String resultat = vote.get("actions");
		Collegue collegue = collegueRepo.findByPseudo(pseudo);
		int ancienScore = collegue.getScore();
		int nouveauScore;
		if(resultat.equals("AIMER")) {
			nouveauScore = ancienScore + 10;
		} else {
			nouveauScore = ancienScore - 5;
		}
		collegue.setScore(nouveauScore);
		collegueRepo.save(collegue);
		return collegue;	
	}
	
	
}
