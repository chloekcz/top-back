package dev.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Vote;
import dev.top.repos.VoteRepo;

@CrossOrigin
@RestController()
@RequestMapping("/vote")
public class VoteController {
	
	@Autowired
	private VoteRepo voteRepo;
	
	
	@PostMapping("votes")
	public Vote save(@RequestBody Vote vote) {
		return voteRepo.save(vote);
	}
	
}
