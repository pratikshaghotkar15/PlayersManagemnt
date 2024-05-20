package com.player.ComparatorExample;

import java.util.Comparator;

import com.player.entity.Player;

public class ScoreComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		Player p1=(Player) o1;
		
		Player p2=(Player) o2;
		
		
		return p1.getAverageScore() .compareTo(p2.getAverageScore());
	}

}
