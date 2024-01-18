package codingtest.baekjoon.문자열;

import java.util.Scanner;

public class 문자와문자열 {

	public static void main(String[] args) {
	
		Scanner sc 	= new Scanner(System.in);
		String str 	= sc.next();
		int index 	= sc.nextInt();
		String result = str.substring(index - 1, index);
		System.out.println(result);
		
	}
}
