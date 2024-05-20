package com.player.service;

import java.util.List;

import com.player.entity.Player;

public interface PlayerService {
	
	public List<Player> getAll();
	
	public String savePlayer(Player player);
	
	public String updatePlayer(Integer id,Player player);
	
	public boolean deletePlayer(Integer id);
	
	public Player getById(Integer id);
	
	public List<Player> findByCountrList(String country);
	
	public List<Player> getPlayersByAverageScore(Long averageScore);
	
	public List<Player> getPlayersByAverageScoreThenSort(Long averageScore);
	
	
	
	

}
