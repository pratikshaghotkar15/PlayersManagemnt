package com.player.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.entity.CricketMatch;
import com.player.repo.MatchRepo;

@Service
public class CricketMatchServiceImpl implements CricketMatchService{

	@Autowired
	private MatchRepo matchRepo;

	@Override
	public CricketMatch saveMatchDetails(CricketMatch cricMatch) {
		CricketMatch cricketMatch = matchRepo.save(cricMatch);
		return cricketMatch;
	}

	@Override
	public List<CricketMatch> getAll() {
		return matchRepo.findAll();
	}
	
	
}
