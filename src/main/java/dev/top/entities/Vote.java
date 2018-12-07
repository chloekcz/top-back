package dev.top.entities;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Collegue collegue;
	private Vote vote;
	private LocalDate date;
	private int score;
	
	public Vote(Collegue collegue, Vote vote, LocalDate date, int score) {
		this.collegue = collegue;
		this.vote = vote;
		this.date = date;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collegue getCollegue() {
		return collegue;
	}

	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
		
	
}
