package com.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.player.entity.Player;
import com.player.repo.PlayerRepo;
import com.player.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlayerRepo playerRepo;

	@PostMapping("/player")
	public ResponseEntity<String> savePlayer(@RequestBody Player player) {

		String savePlayer = playerService.savePlayer(player);

		return new ResponseEntity<>(savePlayer, HttpStatus.CREATED);

	}

	@PutMapping("/player/{id}")
	public ResponseEntity<String> updatePlayer(@PathVariable("id") Integer id, @RequestBody Player player) {

		String updatePlayer = playerService.updatePlayer(id, player);

		return new ResponseEntity<>(updatePlayer, HttpStatus.OK);

	}

	@DeleteMapping("/player/{id}")
	public ResponseEntity<String> savePlayer(@PathVariable("id") Integer id) {

		boolean deletePlayer = playerService.deletePlayer(id);

		if (deletePlayer) {
			return new ResponseEntity<>("players Details deleted successfully", HttpStatus.OK);
		}

		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/player")
	public ResponseEntity<List<Player>> getall() {
		List<Player> all = playerService.getAll();
		return new ResponseEntity<>(all,HttpStatus.OK);
	}

	@GetMapping("/player/{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable("id") Integer id) {

		Player player = playerService.getById(id);

		return new ResponseEntity<>(player, HttpStatus.OK);
	}
	
	@GetMapping("/player/getBy/{country}")
	public ResponseEntity<List<Player>> getPlayerById(@PathVariable("country") String country) {

		List<Player> list = playerService.findByCountrList(country);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/player/getByAverageScore/{averageScore}")
	public ResponseEntity<List<Player>> getPlayerById(@PathVariable("averageScore") Long averageScore) {

		List<Player> playersByAverageScore = playerService.getPlayersByAverageScore(averageScore);

		return new ResponseEntity<>(playersByAverageScore, HttpStatus.OK);
	}
	
	
	@GetMapping("/player/getByAverageScoreAndSort/{averageScore}")
	public ResponseEntity<List<Player>> get(@PathVariable("averageScore") Long averageScore){
		
		List<Player> playersByAverageScoreThenSort = playerService.getPlayersByAverageScoreThenSort(averageScore);
		
		return new ResponseEntity<>(playersByAverageScoreThenSort,HttpStatus.OK);
	}


}
