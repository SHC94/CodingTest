package codingtest.baekjoon.String;

import java.util.Scanner;

public class 진법변환 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		String input	= sc.next();
		int N			= sc.nextInt();

		System.out.println(Integer.parseInt(input, N));
		
	}
}
