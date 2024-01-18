package codingtest.baekjoon.브루트포스;

import java.util.Scanner;

public class 분해합 {
	
	public static void main(String[] args) {
		Scanner sc	= new Scanner(System.in);
		int N	 	= sc.nextInt();
		Boolean r	= true;
		for(int a = 1 ; a < N ; a++) {
			int sum = a;
			
			String str = String.valueOf(a);
			for(int b = 0 ; b < str.length() ; b++) {
				sum += Integer.parseInt(String.valueOf(str.charAt(b)));
			}
			
			if(sum == N) {
				System.out.println(a);
				r = false;
				break;
			}
			
		}
		
		if(r) System.out.println(0);
	}

}