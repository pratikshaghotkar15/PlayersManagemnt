package com.player.service;

import java.util.List;

import com.player.entity.CricketMatch;

public interface CricketMatchService {
	
	public CricketMatch saveMatchDetails(CricketMatch cricMatch);
	
	public List<CricketMatch> getAll();
	}
