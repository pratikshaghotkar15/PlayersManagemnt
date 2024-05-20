package com.player.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.player.entity.CricketMatch;

public interface MatchRepo extends JpaRepository<CricketMatch,Integer>{
	
	

}
