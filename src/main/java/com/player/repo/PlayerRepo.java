package com.player.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.player.entity.Player;

public interface PlayerRepo extends JpaRepository<Player,Integer>{
	
	public List<Player>  findByCountry(String country);
	
	@Query(value = "select p from  Player p where p.averageScore> :averageScore")
	public List<Player> getPlayersByAverageScore(@Param("averageScore")Long averageScore);

}
