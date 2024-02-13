package codingtest.programmers.level1;

import java.util.*;

public class 붕대감기 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/250137
		
//		입출력 예
//		bandage		health	attacks									result
//		{5, 1, 5}	30		{{2, 10}, {9, 15}, {10, 5}, {11, 5}}	5
//		{3, 2, 7}	20		{{1, 15}, {5, 16}, {8, 6}}				-1
//		{4, 2, 7}	20		{{1, 15}, {5, 16}, {8, 6}}				-1
//		{1, 1, 1}	5		{{1, 2}, {3, 2}}						3

//		어떤 게임에는 붕대 감기라는 기술이 있습니다.
//		붕대 감기는 t초 동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복합니다. 
//		t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복합니다. 
//		게임 캐릭터에는 최대 체력이 존재해 현재 체력이 최대 체력보다 커지는 것은 불가능합니다.
		
//		기술을 쓰는 도중 몬스터에게 공격을 당하면 기술이 취소되고, 공격을 당하는 순간에는 체력을 회복할 수 없습니다. 
//		몬스터에게 공격당해 기술이 취소당하거나 기술이 끝나면 그 즉시 붕대 감기를 다시 사용하며, 연속 성공 시간이 0으로 초기화됩니다.
//		몬스터의 공격을 받으면 정해진 피해량만큼 현재 체력이 줄어듭니다. 
//		이때, 현재 체력이 0 이하가 되면 캐릭터가 죽으며 더 이상 체력을 회복할 수 없습니다.
//		당신은 붕대감기 기술의 정보, 캐릭터가 가진 최대 체력과 몬스터의 공격 패턴이 주어질 때 캐릭터가 끝까지 생존할 수 있는지 궁금합니다.
//		붕대 감기 기술의 시전 시간, 1초당 회복량, 추가 회복량을 담은 1차원 정수 배열 bandage와 최대 체력을 의미하는 정수 health, 
//		몬스터의 공격 시간과 피해량을 담은 2차원 정수 배열 attacks가 매개변수로 주어집니다. 
//		모든 공격이 끝난 직후 남은 체력을 return 하도록 solution 함수를 완성해 주세요. 
//		만약 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면 -1을 return 해주세요.
				
//		int[] bandage		= {5, 1, 5};							// 시전 시간, 1초당회복량, 추가 회복
//		int health 			= 30;									// 최대 체력
//		int[][] attacks		= {{2, 10}, {9, 15}, {10, 5}, {11, 5}};	// 공격 시간과 피해
		
//		int[] bandage		= {3, 2, 7};							// 시전 시간, 1초당회복량, 추가 회복
//		int health 			= 20;									// 최대 체력
//		int[][] attacks		= {{1, 15}, {5, 16}, {8, 6}};			// 공격 시간과 피해
		
		int[] bandage		= {4, 2, 7};							// 시전 시간, 1초당회복량, 추가 회복
		int health 			= 20;									// 최대 체력
		int[][] attacks		= {{1, 15}, {5, 16}, {8, 6}};			// 공격 시간과 피해
		
//		int[] bandage		= {1, 1, 1};							// 시전 시간, 1초당회복량, 추가 회복
//		int health 			= 5;									// 최대 체력
//		int[][] attacks		= {{1, 2}, {3, 2}};						// 공격 시간과 피해
		
		int result 	= process(bandage, health, attacks);
		
        System.out.println(result);
	}

	private static int process(int[] bandage, int health, int[][] attacks) {
		int result = health;
		
		HashMap<Integer, Integer> attack = new HashMap<>();

		for(int a = 0 ; a < attacks.length ; a++) 
			attack.put(attacks[a][0], attacks[a][1]);
		
		int time = 0;						// 시간
		int continuousCastingTime = 0;		// 연속 시전 시간
		
		while(!attack.isEmpty()) {
			time++;
			continuousCastingTime++;
			
			// 몬스터 공격 xxxxxx
			if(attack.get(time) == null) {
				
				// 붕대 감기는 t초 동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복합니다.
				result = health <= result + bandage[1] ? health : result + bandage[1];
				
				// t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복합니다. 
				// 게임 캐릭터에는 최대 체력이 존재해 현재 체력이 최대 체력보다 커지는 것은 불가능합니다.
				if(continuousCastingTime == bandage[0]) {
					continuousCastingTime = 0;
					result = health <= result + bandage[2] ? health : result + bandage[2]; 
				}
			
			// 몬스터 공격 ooooooo
			} else {
				// 몬스터에게 공격당해 기술이 취소당하거나 기술이 끝나면 그 즉시 붕대 감기를 다시 사용하며, 
				// 연속 성공 시간이 0으로 초기화됩니다.
				continuousCastingTime = 0;
				
				result = result - attack.get(time);
				
				if(result <= 0) break;
				
				attack.remove(time); 
			}
			
		}
		
		return result <= 0 ? -1 : result;
	}

}
