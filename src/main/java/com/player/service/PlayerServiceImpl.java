package com.player.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.ComparatorExample.ScoreComparator;
import com.player.entity.Player;
import com.player.repo.PlayerRepo;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepo playerRepo;
	

	@Override
	public String savePlayer(Player player) {
		if (playerRepo.findById(player.getPlayer_id()).isPresent()) {
			return "player alredy present";
		}
		
		Player savedPlayer = playerRepo.save(player);
		
		if (savedPlayer == null) {
			return "something went wrong";
		}
		return "player details saved successfully";
	}

	@Override
	public String updatePlayer(Integer id, Player player) {
		player.setPlayer_id(id);
		Player player2 = playerRepo.save(player);
		if (player2 == null) {
			return "something went wrong";
		}
		return "players details updated successfully";
	}

	@Override
	public boolean deletePlayer(Integer id) {
		playerRepo.deleteById(id);
		return true;
	}

	@Override
	public Player getById(Integer id) {
		Player player = playerRepo.findById(id).get();
		return player;
	}

	@Override
	public List<Player> findByCountrList(String country) {
		List<Player> list = playerRepo.findByCountry(country);
		return list;
	}

	@Override
	public List<Player> getPlayersByAverageScore(Long averageScore) {

		List<Player> playersByAverageScore = playerRepo.getPlayersByAverageScore(averageScore);

		return playersByAverageScore;
	}

	@Override
	public List<Player> getPlayersByAverageScoreThenSort(Long averageScore) {
		
		List<Player> playersByAverageScore = playerRepo.getPlayersByAverageScore(averageScore);
		
		Collections.sort(playersByAverageScore, new ScoreComparator());
		
		return playersByAverageScore;
	}

	@Override
	public List<Player> getAll() {
		return playerRepo.findAll();
	}

}
