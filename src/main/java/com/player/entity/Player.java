package com.player.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer player_id;

	private String Name;

	private LocalDate dob;

	private Long averageScore;

	private String country;

	@JsonBackReference
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
	private List<CricketMatch> matches; // many matches can played by one player

	public Integer getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Integer player_id) {
		this.player_id = player_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<CricketMatch> getMatches() {
		return matches;
	}

	public void setMatches(List<CricketMatch> matches) {
		this.matches = matches;
	}

	public Long getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Long averageScore) {
		this.averageScore = averageScore;
	}
	
	

	

	

	
}
