package codingtest.baekjoon.배열;

import java.util.HashMap;
import java.util.Scanner;

public class 개수세기 {

	public static void main(String[] args) {
		
		HashMap<Integer, Integer> result = new HashMap<>();
		Scanner sc 		= new Scanner(System.in);
		int N 			= sc.nextInt();

		for(int a = 0 ; a < N ; a++) { 
			int key = sc.nextInt();
			if(result.containsKey(key)) {
				result.put(key, result.get(key) + 1);	
			} else {
				result.put(key, 1);
			}
		}
		
		int resultKey	= sc.nextInt();	
			
		if(result.containsKey(resultKey)) {
			System.out.println(result.get(resultKey));	
		} else {
			System.out.println(0);
		}
		
		
		
    }
}
