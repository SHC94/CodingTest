package codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 달리기경주 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/178871

//		players		callings	result
//		["mumu", "soe", "poe", "kai", "mine"]	
//		["kai", "kai", "mine", "mine"]	
//		["mumu", "kai", "mine", "soe", "poe"]
		
		String[] players	= {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings	= {"kai", "kai", "mine", "mine"};
		
		String[] result = process(players, callings);
		System.out.println(Arrays.toString(result));
		
        
	}

	private static String[] process(String[] players, String[] callings) {
		
		int playerCnt = players.length;
		HashMap<String, Integer> ranking = new HashMap<>();
        
        for(int i = 0; i < playerCnt ; i++) 
        	ranking.put(players[i], i);
        
        for(String player : callings) { 
            int rank = ranking.get(player);
            
            String frontPlayer = players[rank - 1];
            
            ranking.replace(frontPlayer, rank);
            
            players[rank] = frontPlayer;
            
            ranking.replace(player, rank - 1);
            
            players[rank - 1] = player; 
        }
        
        return players;
	}

}
