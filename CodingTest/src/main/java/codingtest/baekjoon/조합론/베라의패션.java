package codingtest.baekjoon.조합론;

import java.util.Scanner;

public class 베라의패션 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] top 		= new int[N];
		int[] bottom 	= new int[N];
		for(int a = 0 ; a < N ; a++) {
			top[a] = a;
			bottom[a] = a;
		}
		
		int result = 0;
		
		for(int a = 0 ; a < N ; a++) {
			for(int b = a ; b < N ; b++) {
				if(top[a] != bottom[b]) result++; 
			}
		}
		
		System.out.println(result * 2);
		
	}

}
