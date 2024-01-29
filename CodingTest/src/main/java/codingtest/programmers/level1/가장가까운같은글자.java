package codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 가장가까운같은글자 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/142086
		
//		입출력 예
//		s			result
//		"banana"	[-1, -1, -1, 2, 2, 2]
//		"foobar"	[-1, -1, 1, -1, -1, -1]
		
		String s 		= "foobar";
		int[] result 	= process(s);
		
//        System.out.println(result);
//        System.out.println(result.toString());
        System.out.println(Arrays.toString(result));
		
	}

	private static int[] process(String s) {
		int[] result = new int[s.length()];
		
		HashMap<String, Integer> equipment = new HashMap<>();
		
		for(int a = 0 ; a < s.length() ; a++) {
			String element = String.valueOf(s.charAt(a));
			
			if(equipment.containsKey(element)) result[a] = a - equipment.get(element);
			else result[a] = -1;
			
			equipment.put(element, a);
		}
		return result;
	}

}
