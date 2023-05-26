package codingtest.baekjoon.String;

import java.util.Scanner;

public class 진법변환2 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int input		= sc.nextInt();
		int N			= sc.nextInt();

		System.out.println(Integer.toString(input, N).toUpperCase());
		
	}
}
