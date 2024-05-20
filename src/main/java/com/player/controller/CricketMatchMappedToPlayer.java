package com.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.entity.CricketMatch;
import com.player.entity.Player;
import com.player.repo.MatchRepo;
import com.player.repo.PlayerRepo;

@RestController
public class CricketMatchMappedToPlayer {
	
	@Autowired
	private MatchRepo matchRepo;
	
	@Autowired
	private PlayerRepo playerRepo;
	
	
	@PutMapping("/mapped/{playerId}/{matchId}")
	public ResponseEntity<String> mapPlayerToMatch(@PathVariable("playerId")Integer playerId,@PathVariable("matchId")Integer matchId) {
		
		CricketMatch cricketMatch = matchRepo.findById(matchId).get();
		
		Player player = playerRepo.findById(playerId).get();
		
		cricketMatch.setPlayer(player);
		
	    matchRepo.save(cricketMatch);
		
		return new ResponseEntity<>("Mapped successfully",HttpStatus.OK);
		
	}

}
