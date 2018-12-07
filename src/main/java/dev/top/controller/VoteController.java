package dev.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Vote;
import dev.top.repos.VoteRepo;

@CrossOrigin
@RestController()
@RequestMapping()
public class VoteController {
	
	@Autowired
	private VoteRepo voteRepo;
	

}
