package codingtest.baekjoon.구현;

import java.util.HashMap;
import java.util.Scanner;

public class 알파벳개수 {
	
	public static void main(String[] args) {
		Scanner sc 							= new Scanner(System.in);
		HashMap<String, Integer> resultMap 	= new HashMap<String, Integer>();
		StringBuilder result 				= new StringBuilder();
		
		String S = sc.next();
		
		for(int a = 0 ; a < S.length(); a++) {
			String str = String.valueOf(S.charAt(a));
			if(resultMap.containsKey(str)) {
				resultMap.put(str, resultMap.get(str) + 1);
			} else {
				resultMap.put(str, 1);
			}//end if()
		}//end for()

		for(int a = 97 ; a <= 122 ; a++) {
			String key = String.valueOf((char) a);
			if(resultMap.containsKey(key)) {
				result.append(resultMap.get(key)).append(" ");
			} else {
				result.append(0).append(" ");
			}//end if()
		}//end for()
		
		
		System.out.println(result.toString());
	}//end main()

}//end class()