package com.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.player.entity.CricketMatch;
import com.player.service.CricketMatchService;

@RestController
public class CricketMatchController {

	@Autowired
	private CricketMatchService cricketMatchService;

	@PostMapping("/match")
	public ResponseEntity<CricketMatch> saveMatch(@RequestBody CricketMatch match) {

		CricketMatch saveMatchDetails = cricketMatchService.saveMatchDetails(match);
		
		return new ResponseEntity<>(saveMatchDetails,HttpStatus.CREATED);
	}


	@GetMapping("/match")
	public ResponseEntity<List<CricketMatch>> getall() 
	{
		 List<CricketMatch> all = cricketMatchService.getAll();
		 
		 return new ResponseEntity<>(all, HttpStatus.OK); 
	}
}
