package codingtest.baekjoon.배열;

import java.util.Scanner;

public class 최댓값 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int max			= 0;
		int row			= 0;
		int col			= 0;
		
		for(int a = 1 ; a <= 9 ; a++) {
			for(int b = 1 ; b <= 9 ; b++) {
				int input = sc.nextInt();
				if(max <= input) {
					max = input;
					row = a;
					col = b;
				}
			}
		}
		
		System.out.println(max);
		System.out.print(row + " " + col);

    }

}
