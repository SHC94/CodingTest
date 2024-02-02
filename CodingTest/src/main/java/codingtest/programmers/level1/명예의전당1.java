package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 명예의전당1 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/138477

//		k	score	result
//		3	[10, 100, 20, 150, 1, 100, 200]	[10, 10, 10, 20, 20, 100, 100]
//		4	[0, 300, 40, 300, 20, 70, 150, 50, 500, 1000]	[0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
		
		int k 			= 3;
		int[] score		= {10, 100, 20, 150, 1, 100, 200};
		
		List<Integer> result = solution(k, score);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
		
        
	}

	private static List<Integer> solution(int k, int[] score) {
		List<Integer> result = new ArrayList<>();
		
		List<Integer> list = new ArrayList<>();
		for(int a = 0 ; a < score.length ; a++) {
			int point = score[a];
			list.add(point);
			Collections.sort(list, Collections.reverseOrder());
			if(list.size() < k) result.add(list.get(list.size() - 1));
			else result.add(list.get(k - 1));
		}
        
        return result;
    }
	

}
