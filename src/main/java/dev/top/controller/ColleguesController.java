package dev.top.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

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
	
	
	
	
	// Add a colleague
	@PostMapping
	public ResponseEntity<String> isExists(@RequestBody Map<String, String> colJson) {
		
		String matricule = colJson.get("matricule");

		RestTemplate rt = new RestTemplate();
		
		Collegue[] collegue = rt.getForObject("http://collegues-api.cleverapps.io/collegues?matricule=" + matricule , Collegue[].class);
		
		if (collegue.length == 1) {
			collegueRepo.save(new Collegue(colJson.get("photo"), colJson.get("pseudo"), 0, collegue[0].getNom(), collegue[0].getPrenom(), collegue[0].getEmail(), collegue[0].getAdresse()));
			return new ResponseEntity<String>("Great !", HttpStatus.ACCEPTED);
		} 
		return new ResponseEntity<String>("Ooooops", HttpStatus.BAD_REQUEST);
	}

	
}
