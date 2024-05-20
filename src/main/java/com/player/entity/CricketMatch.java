package com.player.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matches")
public class CricketMatch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matchId;

	private Long score;

	private String stadium;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;
	
	
	

	public CricketMatch(Integer matchId, Long score, String stadium) {
		super();
		this.matchId = matchId;
		this.score = score;
		this.stadium = stadium;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	
	
	
	
}
