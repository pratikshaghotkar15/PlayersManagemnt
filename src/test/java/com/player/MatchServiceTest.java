package com.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.player.entity.CricketMatch;
import com.player.repo.MatchRepo;
import com.player.service.CricketMatchServiceImpl;

@ExtendWith(SpringExtension.class)
public class MatchServiceTest {
	
	@Mock
    private MatchRepo matchRepo;

    @InjectMocks
    private CricketMatchServiceImpl matchService;


    @Test
    public void gellmatchTest() {
    	
    	when(matchRepo.findAll())
    	.thenReturn(Arrays.asList(new CricketMatch(1,120L,"lll"),new CricketMatch(2,130L,"mmm")));
    	
    	List<CricketMatch> all = matchService.getAll();
    	
    	assertEquals(1, all.get(0).getMatchId());
    	assertEquals(2, all.get(1).getMatchId());
    }
    
    @Test
    public void saveMatchTest() {
    	
    	CricketMatch cricketMatch=new CricketMatch(1, 12L, "hhh");
    	
    	when(matchRepo.save(cricketMatch))
    	.thenReturn(cricketMatch);
    	
        CricketMatch saveMatchDetails = matchService.saveMatchDetails(cricketMatch);
    	
    	assertNotNull(saveMatchDetails);
    }
    
    
  
	
	

}
