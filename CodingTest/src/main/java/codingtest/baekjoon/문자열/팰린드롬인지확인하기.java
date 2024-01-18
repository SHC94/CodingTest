package codingtest.baekjoon.문자열;

import java.util.Scanner;

public class 팰린드롬인지확인하기 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		String input	= sc.next();
		boolean result  = true;
		int forCnt 		= input.length() / 2;
		
		for(int a = 0 ; a < forCnt ; a++) {
			String start 	= input.substring(a, a + 1);
			String end 		= input.substring(input.length() - (a + 1), input.length() - a);
			
			if(!start.equals(end)) {
				result = false;
				break;
			}
		}
		
		if(result) System.out.println("1");
		else System.out.println("0");
		
	}
	
}
